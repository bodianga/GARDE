package repository

import anorm._
import models._
import org.scalatest.BeforeAndAfterEach
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneServerPerSuite
import play.api.db.Database
import play.api.test.Injecting

class FeatureRepositoryTest extends PlaySpec with GuiceOneServerPerSuite with Injecting with BeforeAndAfterEach {

  val db = inject[Database]
  val featureRepository = inject[FeatureRepository]

  val featureDBDTO1 = FeatureDBDTO(1, 1, "path1", Some("backgroundAsJson1"), Some("language1"), Some("keyword1"), "name1", "description1")
  val featureDBDTO2 = FeatureDBDTO(2, 1, "path2", Some("backgroundAsJson2"), Some("language2"), Some("keyword2"), "name2", "description2")
  val featureDBDTO3 = FeatureDBDTO(3, 2, "path3", Some("backgroundAsJson3"), Some("language3"), Some("keyword3"), "name3", "description3")
  val featuresDBDTO = Seq(featureDBDTO1)

  val branch1 = Branch(1, "name", true, "id1")
  val branch2 = Branch(2, "name2", true, "id1")
  val branch3 = Branch(3, "name3", false, "id2")
  val branches = Seq(branch1, branch2, branch3)

  val project1 = Project("id1", "name1", "repositoryUrl1", "stableBranch1", "featuresRootPath1")
  val project2 = Project("id2", "name2", "repositoryUrl2", "stableBranch2", "featuresRootPath2")
  val project3 = Project("id3", "name3", "repositoryUrl3", "stableBranch3", "featuresRootPath3")

  val projects = Seq(project1, project2, project3)

  override def beforeEach() {

    db.withConnection { implicit connection =>
      projects.foreach { project =>
        SQL"""INSERT INTO project (id, name, repositoryUrl, stableBranch,featuresRootPath)
           VALUES (${project.id}, ${project.name}, ${project.repositoryUrl},${project.stableBranch}, ${project.featuresRootPath})"""
          .executeInsert()
      }
    }

    db.withConnection { implicit connection =>
      featuresDBDTO.foreach { feature =>
        SQL"""INSERT INTO feature (id, branchId, path, backgroundAsJson language, keyword, name, description)
              VALUES(${feature.id}, ${feature.branchId}, ${feature.path}, ${feature.backgroundAsJson}, ${feature.language}, ${feature.keyword}, ${feature.name}, ${feature.description})"""
          .executeUpdate()
      }
    }

    db.withConnection { implicit connection =>
      branches.foreach { branch =>
        SQL"""INSERT INTO branch (id, name, isStable, projectId)
           VALUES (${branch.id}, ${branch.name}, ${branch.isStable}, ${branch.projectId})"""
          .executeInsert()
      }
    }
  }

  override def afterEach() {
    db.withConnection { implicit connection =>
      SQL"TRUNCATE TABLE feature".executeUpdate()
      SQL"TRUNCATE TABLE branch".executeUpdate()
      SQL"TRUNCATE TABLE project".executeUpdate()
    }
  }

  "FeatureRepository" should {

    "get all features" in {
      featureRepository.findAllFeatures() must contain theSameElementsAs featuresDBDTO
    }

    "get all features by branchId" in {
      featureRepository.findAllFeatureByFeatureId(1) must contain theSameElementsAs Seq(featureDBDTO1, featureDBDTO2)
    }

    "get a feature by branchId" in {
      featureRepository.findFeatureByBranchId(1, 1) must contain theSameElementsAs Seq(featureDBDTO1)
    }

    "check if a branch exist by branchId" in {
      featureRepository.existByBranchId(1, 1) mustBe true
    }

    /*"create a feature by branchId" in {
      val featureDBDTO5 = Feature(5, 1, "path5", Some("backgroundAsJson5"), Some("language5"), Some("keyword5"), "name5", "description5", Some)
      featureRepository.save(featureDBDTO5)
      featureRepository.findFeatureByBranchId(5, 1) mustBe Seq(featureDBDTO5)
    }*/

    /*"update a feature by branchId" in {
      val featureDBDTO1 = Feature("1", "1", "path12", Some("backgroundAsJson1"), Some("language12"), Some("keyword12"), "name12", "description12")
      featureRepository.save(featureDBDTO1)
      featureRepository.findFeatureByBranchId(1, 1) mustBe Seq(featureDBDTO1)
    }

    "save all features by id" in {
      val newFeatures = Seq(Feature(4, 1, "path12", Some("backgroundAsJson1"), Some("language12"), Some("keyword12"), "name12", "description12"))
      featureRepository.saveAll(newFeatures)
      featureRepository.findAllFeatureByFeatureId(1) must contain theSameElementsAs (newFeatures :+ featureDBDTO1 :+ featureDBDTO2)
    }*/
  }
}