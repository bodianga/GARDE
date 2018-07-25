package repository

import anorm._
import models._
import org.scalatest.BeforeAndAfterEach
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneServerPerSuite
import play.api.db.Database
import play.api.test.Injecting

class ScenarioRepositoryTest extends PlaySpec with GuiceOneServerPerSuite with Injecting with BeforeAndAfterEach {
  val db = inject[Database]
  val scenarioRepository = inject[ScenarioRepository]

  val scenarioBD1 = ScenarioBD(1, "description1", "scenarioType1", "workflowStep1", "caseType1", "abstractionLevel1", Option("stepsAsJson1"), Option("keyword1"), Option("name1"), 1)
  val scenarioBD2 = ScenarioBD(2, "description2", "scenarioType2", "workflowStep2", "caseType2", "abstractionLevel2", Option("stepsAsJson2"), Option("keyword2"), Option("name2"), 1)
  val scenarioBD3 = ScenarioBD(3, "description3", "scenarioType3", "workflowStep3", "caseType3", "abstractionLevel3", Option("stepsAsJson3"), Option("keyword3"), Option("name3"), 2)
  val scenarios = Seq(scenarioBD1, scenarioBD2, scenarioBD3)

  val featureDB1 = FeatureDB(1, "path1", "name1", "description1", Option("backgroundAsJson1"), 1, Option("language1"), Option("keyword1"))
  val featureDB2 = FeatureDB(2, "path2", "name2", "description2", Option("backgroundAsJson2"), 1, Option("language2"), Option("keyword2"))
  val featuresBD = Seq(featureDB1, featureDB2)

  override def beforeEach(): Unit = {
    db.withConnection { implicit connection =>
      scenarios.foreach { scenario =>
        SQL"""INSERT INTO scenario(id, description, scenarioType, workflowStep, caseType, abstractionLevel, stepsAsJson, keyword, name, featureId)
              VALUES(${scenario.id}, ${scenario.description}, ${scenario.scenarioType}, ${scenario.workflowStep}, ${scenario.caseType}, ${scenario.abstractionLevel}, ${scenario.stepsAsJson}, ${scenario.keyword}, ${scenario.name}, ${scenario.featureId})"""
          .executeUpdate()
      }
    }

    db.withConnection { implicit connection =>
      featuresBD.foreach { feature =>
        SQL"""INSERT INTO feature (id,  path, name, description, backgroundAsJson, branchId, language, keyword)
              VALUES(${feature.id}, ${feature.path}, ${feature.name}, ${feature.description}, ${feature.backgroundAsJson}, ${feature.branchId}, ${feature.language}, ${feature.keyword})"""
          .executeUpdate()
      }
    }
  }

  override def afterEach() {
    db.withConnection { implicit connection =>
      SQL"TRUNCATE TABLE feature".executeUpdate()
      SQL"TRUNCATE TABLE scenario".executeUpdate()
    }
  }

  "ScenarioRepository" should {
    "get all scenarios" in {
      scenarioRepository.findAllScenarios() must contain theSameElementsAs scenarios
    }

    "get all scenarios by featureId" in {
      scenarioRepository.findAllScenariosByFeatureId(1) must contain theSameElementsAs Seq(scenarioBD1, scenarioBD2)
    }

    "get a scenario by featureId" in {
      scenarioRepository.findScenarioByFeatureId(1, 1) must contain theSameElementsAs Seq(scenarioBD1)
    }

    "check if a scenario exist by featureId" in {
      scenarioRepository.existByFeatureId(1, 1) mustBe true
    }

    "save all branches by branchId" in {
      val newScenarios = Seq(ScenarioBD(5, "description1", "scenarioType1", "workflowStep1", "caseType1", "abstractionLevel1", Option("stepsAsJson1"), Option("keyword1"), Option("name1"), 1)
        , ScenarioBD(6, "description1", "scenarioType1", "workflowStep1", "caseType1", "abstractionLevel1", Option("stepsAsJson1"), Option("keyword1"), Option("name1"), 1))
      scenarioRepository.saveAll(newScenarios)
      scenarioRepository.findAllScenariosByFeatureId(1) must contain theSameElementsAs (newScenarios :+ scenarioBD1 :+ scenarioBD2)
    }

    "get scenario by id" in {
      scenarioRepository.findById(scenarioBD1.id) mustBe Some(scenarioBD1)
    }
  }
}
