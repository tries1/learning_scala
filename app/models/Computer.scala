package models

import java.util.Date
import anorm.SqlParser._

case class Computer (id: Option[Long] = None, name: String, introduced: Option[Date], discontinued: Option[Date], companyId: Option[Long])

object Computer {
  /*val simple = {
    get[Option[Long]]("computer.id") ~
    get[String]("computer.name") ~
    get[Option[Date]]("computer.introduced") ~
    get[Option[Date]]("computer.discontinued") ~
    get[Option[Long]]("computer.company_id") map {
      case id~name~introduced~discontinued~companyId =>
        Computer(id, name, introduced, discontinued, companyId)
    }
  }

  val withCompany = Computer.simple ~ (Company.simple ?) map {
    case computer~company => (computer, company)
  }*/
}