package steps

import java.io._
import java.net._
import java.nio.file._
import java.util

import cucumber.api.scala.{EN, ScalaDsl}
import models._
import org.eclipse.jgit.api._
import org.scalatest.mockito.MockitoSugar
import play.api.test.Helpers._
import play.api.test._
import services._

import scala.collection.JavaConverters._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._
import scala.io.Source


class GetFeaturesSteps extends ScalaDsl with EN with MockitoSugar {

  import CommonSteps._

  val projectService = Injector.inject[ProjectService]
  val gitService = Injector.inject[GitService]

  val featureContent = "Feature: As a user, I want some book suggestions so that I can do some discovery"


  Given("""^a project in theGardener hosted on a remote server$""") { () =>
    val git = initRemoteRepository("master", "target/data/GetFeatures/library/suggestionsWS/")
    addFile(git, "target/data/GetFeatures/library/suggestionsWS/", "test/features/suggestions/provide_book_suggestions.feature", featureContent)

    val project = Project("suggestionsWS", "Suggestions WebServices", new URL(new URL("file:"), new File("target/data/GetFeatures/library/suggestionsWS/").getAbsolutePath).toURI.toString, "master", "test/features")
    projectRepository.save(project)
    CommonSteps.projects = Map(project.id -> project)
  }

  Given("""^the branch "([^"]*)" of the project "([^"]*)" is already checkout$""") { (branch: String, projectId: String) =>
    val localRepository = s"$projectsRootDirectory/$projectId/$branch"

    Await.result(gitService.clone(projects(projectId).repositoryUrl, localRepository)
      .flatMap(_ => gitService.checkout(branch, localRepository)), 30.seconds)
  }

  Given("""^the file "([^"]*)" of the server "([^"]*)" in the project "([^"]*)" on the branch "([^"]*)" is updated with content$""") { (file: String, remoteRepository: String, project: String, branch: String, content: String) =>
    val projectRepositoryPath = s"$remoteRepository/$project"

    val git = Git.open(new File(projectRepositoryPath))
    git.checkout.setName(branch).call()

    Files.write(Paths.get(s"$projectRepositoryPath/$file"), content.getBytes("UTF-8"))

    git.add().addFilepattern(".").call()

    git.commit().setMessage(s"Update file $file").call()
  }

  When("""^BDD features synchronization action is triggered$""") { () =>
    val future = projectService.synchronizeAll()
    Await.result(future, 30.seconds)
  }

  When("""^the synchronization action is triggered by the scheduler$""") { () =>
    Thread.sleep(2000)
  }

  When("""^the synchronization action is triggered by the webhook for project "([^"]*)"$""") { project: String =>
    response = route(app, FakeRequest("POST", s"/api/projects/$project/synchronize")).get
    await(response)
  }

  Then("""^the project BDD features of this project are retrieved from the remote server$""") { () =>
    Source.fromFile("target/data/git/suggestionsWS/master/test/features/suggestions/provide_book_suggestions.feature").mkString mustBe featureContent
  }

  Given("""^we have those branches in the database$""") { branches: util.List[Branch] =>
    branchRepository.saveAll(branches.asScala)
  }

  /*Given("""^we have those features in the database$""") { (featuresBD: util.List[Feature]) =>
    featureRepository.saveAll(features.asScala.map(_.copy(backgroundAsJson = None, language = None, keyword = None)))
  }*/

  Given("""^we have those scenario in the database$""") { (scenariosBD: util.List[ScenarioBD]) =>
    scenarioRepository.saveAll(scenariosBD.asScala.map(_.copy(stepsAsJson = None, keyword = None, name = None)))
  }

  Given("""^we have those stepsAsJSon for the scenario "([^"]*)" in the database$""") { (scenarioId: Int, step: String) =>
    scenarioRepository.findById(scenarioId).map(_.copy(stepsAsJson = Some(step)))
  }

  Given("""^we have those tags in the database$""") { (tags: util.List[Tag]) =>
    tagRepository.saveAll(tags.asScala)
  }

  Then("""^we have now those branches in the database$""") { (branches: util.List[Branch]) =>
    val expectedBranches = branches.asScala
    val actualBranches = branchRepository.findAllBranch()
    expectedBranches must contain theSameElementsAs actualBranches
  }

  Then("""^we have now those features in the database$""") { (features: util.List[FeatureDB]) =>
    val expectedFeatures = features.asScala.map(_.copy(backgroundAsJson = None, language = None, keyword = None)).toList
    val actualFeatures = featureRepository.findAllFeatures()
    expectedFeatures must contain theSameElementsAs actualFeatures
  }

  Then("""^we have now those scenario in the database$""") { (scenario: util.List[ScenarioBD]) =>
    val exceptedScenario = scenario.asScala.map(_.copy(stepsAsJson = None, keyword = None, name = None)).toList
    val actualScenario = scenarioRepository.findAllScenarios()
    exceptedScenario must contain theSameElementsAs actualScenario
  }

  Then("""^we have now those tags in the database$""") { (tags: util.List[Tag]) =>
    val exceptedTags = tags.asScala
    val actualTags = tagRepository.findAllTags()
    exceptedTags must contain theSameElementsAs actualTags
  }

  Then("""^we have now those stepsAsJSon for the scenario "([^"]*)" in the database$""") { (scenarioId: String, expectedJson: String) =>
    // val actualSteps = scenarioRepository.findById(scenarioId.toInt).flatMap(_.stepsAsJson).get
    val actualSteps = scenarioRepository.findById(scenarioId.toInt).map(_.stepsAsJson).get
    //val actualStepsAsJson = Json.parse(actualSteps.toString)
    //val expectedJsonAsJson = Json.parse(expectedJson)
    actualSteps mustBe expectedJson
  }
}