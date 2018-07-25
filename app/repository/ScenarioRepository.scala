package repository

import anorm.SqlParser.{get, scalar}
import anorm._
import javax.inject.Inject
import models.ScenarioBD
import play.api.db.Database

class ScenarioRepository @Inject()(db: Database) {


  val parser = {
    get[Int]("scenario.id") ~
      get[String]("scenario.description") ~
      get[String]("scenario.scenarioType") ~
      get[String]("scenario.workflowStep") ~
      get[String]("scenario.caseType") ~
      get[String]("scenario.abstractionLevel") ~
      get[Option[String]]("scenario.stepsAsJson") ~
      get[Option[String]]("scenario.keyword") ~
      get[Option[String]]("scenario.name") ~
      get[Int]("scenario.featureId") map {
      case id ~ description ~ scenarioType ~ workflowStep ~ caseType ~ abstractionLevel ~ stepsAsJson ~ keyword ~ name ~ featureId =>
        ScenarioBD(id, description, scenarioType, workflowStep, caseType, abstractionLevel, stepsAsJson, keyword, name, featureId)
    }
  }

  def findAllScenarios(): Seq[ScenarioBD] = {
    db.withConnection { implicit connection =>
      SQL"SELECT * FROM scenario".as(parser.*)
    }
  }

  def findAllScenariosByFeatureId(featureId: Int): Seq[ScenarioBD] = {
    db.withConnection { implicit connection =>
      SQL"SELECT * FROM scenario WHERE featureId = $featureId".as(parser.*)
    }
  }

  def findScenarioByFeatureId(scenarioId: Int, featureId: Int): Seq[ScenarioBD] = {
    db.withConnection { implicit connection =>
      SQL" SELECT * FROM scenario WHERE id = $scenarioId AND featureId = $featureId".as(parser.*)
    }
  }

  def existByFeatureId(scenarioId: Int, featureId: Int): Boolean = {
    db.withConnection { implicit connection =>
      SQL"SELECT COUNT(*) FROM scenario WHERE id = $scenarioId AND featureId = $featureId".as(scalar[Long].single) > 0
    }
  }

  def save(scenario: ScenarioBD): ScenarioBD = {
    db.withConnection { implicit connection =>
      SQL"""REPLACE INTO scenario(id, description, scenarioType, workflowStep, caseType, abstractionLevel, stepsAsJson, keyword, name, featureId)
         VALUES(${scenario.id}, ${scenario.description}, ${scenario.scenarioType}, ${scenario.workflowStep}, ${scenario.caseType}, ${scenario.abstractionLevel}, ${scenario.stepsAsJson}, ${scenario.keyword}, ${scenario.name}, ${scenario.featureId})"""
        .executeUpdate()
      SQL"SELECT * FROM scenario WHERE id = ${scenario.id}".as(parser.single)
    }
  }

  def saveAll(scenariosBd: Seq[ScenarioBD]): Seq[ScenarioBD] = {
    scenariosBd.map(save)
  }

  def findById(scenarioId: Int): Option[ScenarioBD] = {
    db.withConnection { implicit connection =>
      SQL"SELECT * FROM scenario WHERE id = $scenarioId".as(parser.singleOpt)
    }
  }

}
