package repository

import anorm.SqlParser._
import anorm._
import javax.inject.Inject
import models._
import play.api.db.Database


case class FeatureDBDTO(id: Int, branchId: Int, path: String, backgroundAsJson: Option[String] = None, language: Option[String], keyword: Option[String], name: String, description: String) {
  def toFeature(tags: Seq[String] = Seq(), scenarios: Seq[ScenarioDefinition] = Seq(), comments: Seq[String] = Seq()): Feature = {
    Feature(this.id.toString, this.branchId.toString, this.path, this.backgroundAsJson, tags, this.language.getOrElse(""), this.keyword.getOrElse(""), this.name, this.description, scenarios, comments)
  }
}


object FeatureDBDTO {
  def apply(feature: Feature): FeatureDBDTO = {
    FeatureDBDTO(feature.id.toInt, feature.branch.toInt, feature.path, feature.backgroundAsJson, Some(feature.language), Some(feature.keyword), feature.name, feature.description)
  }
}

class FeatureRepository @Inject()(db: Database) {

  val parser = {
    get[Int]("feature.id") ~
      get[Int]("feature.branchId") ~
      get[String]("feature.path") ~
      get[Option[String]]("feature.backgroundAsJson") ~
      get[Option[String]]("feature.language") ~
      get[Option[String]]("feature.keyword") ~
      get[String]("feature.name") ~
      get[String]("feature.description") map {
      case id ~ branchId ~ path ~ backgroundAsJson ~ language ~ keyword ~ name ~ description =>
        FeatureDBDTO(id, branchId, path, backgroundAsJson, language, keyword, name, description)
    }
  }

  def findAllFeatures(): Seq[Feature] = {
    db.withConnection { implicit connection =>
      SQL"SELECT * FROM feature".as(parser.*)
    }.map(_.toFeature())
  }

  def findAllFeatureByFeatureId(featureId: Int): Seq[Feature] = {
    db.withConnection { implicit connection =>
      SQL"SELECT * FROM feature WHERE id = $featureId".as(parser.*)
    }.map(_.toFeature().copy(tags = Seq(), comments = Seq(), scenarios = Seq()))
  }

  def save(feature: Feature): Feature = {
    val featureDTO = FeatureDBDTO(feature)
    db.withConnection { implicit connection =>
      SQL"""REPLACE INTO feature(id, branchId, path, name, description, backgroundAsJson, language, keyword )
           VALUES (${feature.id}, ${featureDTO.branchId} ${feature.path}, ${featureDTO.backgroundAsJson}, ${feature.name}, ${feature.description}, ${featureDTO.branchId}, ${feature.language}, ${feature.keyword})"""
        .executeUpdate()
      SQL"SELECT * FROM feature WHERE id = ${feature.id}".as(parser.single)
    }.toFeature()
  }

  def findFeatureByBranchId(featureId: Int, branchId: Int): Seq[Feature] = {
    db.withConnection { implicit connection =>
      SQL" SELECT * FROM feature WHERE id = $featureId AND branchId = $branchId".as(parser.*)
    }.map(_.toFeature())
  }

  def existByBranchId(featureId: Int, branchId: Int): Boolean = {
    db.withConnection { implicit connection =>
      SQL"SELECT COUNT(*) FROM feature WHERE id = $featureId AND branchId = $branchId".as(scalar[Long].single) > 0
    }
  }

  def saveAll(features: Seq[Feature]): Seq[Feature] = {
    features.map(save)
  }
}