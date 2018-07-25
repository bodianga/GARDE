package repository

import anorm._
import models.Tag
import org.scalatest.BeforeAndAfterEach
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneServerPerSuite
import play.api.db.Database
import play.api.test.Injecting

class TagRepositoryTest extends PlaySpec with GuiceOneServerPerSuite with Injecting with BeforeAndAfterEach {
  val db = inject[Database]
  val tagRepository = inject[TagRepository]

  val tag1 = Tag("name1")

  override def beforeEach(): Unit = {
    db.withConnection { implicit connection =>
      SQL"""INSERT INTO tag(name)
        VALUES('name1')"""
        .executeUpdate()
    }
  }

  override def afterEach() {
    db.withConnection { implicit connection =>
      SQL"TRUNCATE TABLE tag".executeUpdate()
      SQL"TRUNCATE TABLE feature".executeUpdate()
    }
  }

  "tagRepository" should {
    "get all tags" in {
      tagRepository.findAllTags() must contain theSameElementsAs Seq(tag1)
    }
  }

  "get tag by name" in {
    tagRepository.findTagByName("name1") must contain theSameElementsAs Seq(tag1)
  }

  "save all tags by name" in {
    val newTags = Seq(Tag("name2"), Tag("name3"))
    tagRepository.saveAll(newTags)
    tagRepository.findAllTags() must contain theSameElementsAs (newTags :+ tag1)
  }
}
