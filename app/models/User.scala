package models

import org.joda.time.DateTime
import slick.lifted.Tag
//import play.api.libs.json._
//import org.json4s.DefaultFormats
import slick.jdbc.MySQLProfile.api._
import com.github.tototoshi.slick.MySQLJodaSupport._

object UserSchema {
  //implicit val format = Json.format[UserRow]
  //implicit val formats = DefaultFormats

  case class UserRow(id: Int, name: String, email: String, createdAt: DateTime)

  class UserTable(tag: Tag) extends Table[UserRow](tag, Some("eduscala"), "user") {
    def * = (id, name, email, createdAt) <> (UserRow.tupled, UserRow.unapply)

    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(email), Rep.Some(createdAt)).shaped.<>({ r => import r._; _1.map(_ => UserRow.tupled((_1.get, _2.get, _3.get, _4.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    val name: Rep[String] = column[String]("name", O.Length(255, varying = true))
    val email: Rep[String] = column[String]("email", O.Length(255, varying = true))
    val createdAt: Rep[DateTime] = column[DateTime]("created_at")


    /*def id = column[Int]("id", O.AutoInc, O.PrimaryKey)
    def name = column[String]("collId", O.Length(255,varying=true))
    def email = column[String]("keyword", O.Length(255,varying=true))*/
  }

  lazy val User = new TableQuery(tag => new UserTable(tag))
}

