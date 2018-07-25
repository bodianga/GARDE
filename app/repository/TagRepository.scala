package repository

import anorm.SqlParser._
import anorm._
import javax.inject.Inject
import models._
import play.api.db.Database

class TagRepository @Inject()(db: Database) {


  private val parser = for {
    name <- str("name")
  } yield Tag(name)

  def findAllTags(): Seq[Tag] = {
    db.withConnection { implicit connection =>
      SQL"SELECT * FROM tag".as(parser.*)
    }
  }

  def saveAll(tags: Seq[Tag]): Seq[Tag] = {
    tags.map(save)
  }

  def save(tag: Tag): Tag = {
    db.withConnection { implicit connection =>
      SQL"""REPLACE INTO tag (name) VALUES (${tag.name})""".executeUpdate()
      SQL"SELECT * FROM tag WHERE name =${tag.name}".as(parser.single)
    }
  }

  def findTagByName(name: String): Seq[Tag] = {
    db.withConnection { implicit connection =>
      SQL"SELECT * FROM tag WHERE name = $name".as(parser.*)
    }
  }
}
