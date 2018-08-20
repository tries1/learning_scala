package models

import slick.jdbc.MySQLProfile.api._
import slick.lifted.Tag

object UserSchema {

  case class UserRow(id: Int, name: String, email: String)

  class UserTable(tag: Tag) extends Table[UserRow](tag, Some("eduscala"), "user") {
    def * = (id, name, email) <> (UserRow.tupled, UserRow.unapply)

    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(email)).shaped.<>({ r => import r._; _1.map(_ => UserRow.tupled((_1.get, _2.get, _3.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    val name: Rep[String] = column[String]("name", O.Length(255, varying = true))
    val email: Rep[String] = column[String]("email", O.Length(255, varying = true))


    /*def id = column[Int]("id", O.AutoInc, O.PrimaryKey)
    def name = column[String]("collId", O.Length(255,varying=true))
    def email = column[String]("keyword", O.Length(255,varying=true))*/
  }

  lazy val User = new TableQuery(tag => new UserTable(tag))
}

