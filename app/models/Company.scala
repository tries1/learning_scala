package models

import anorm.SqlParser._

case class Company (id: Option[Long] = None, name: String)

object Company {
  /*val simple = {
    get[Option[Long]]("company.id") ~
    get[String]("company.name") map { }
  }*/
}