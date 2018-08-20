package services

import anorm.SqlParser._
import anorm._
import javax.inject.{Inject, Singleton}
import models.{Computer, Company, Page}
import play.api.db.DBApi

@Singleton
class ComputerService @Inject()(dbApi: DBApi) {
  /*private val db = dbApi.database("default")

  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Page[(Computer, Option[Company])] = {
    val offset = pageSize * page

    db.withConnection { implicit connection =>
      val computers = SQL(
        """
          select * from computer
          left join company on computer.company_id = company.id
          where computer.name like {filter}
          order by {orderBy} nulls last
          limit {pageSize} offset {offset}
        """.stripMargin)
        .on(
          'pageSize -> pageSize,
          'offset -> offset,
          'orderBy -> orderBy,
          'filter -> filter
        )
        .as(Computer.withCompany *)

      val totalRows = SQL(
        """
          select count(*) from computer
          left join company on computer.company_id = company.id
          where computer.name like {filter}
        """.stripMargin)
        .on(
          'filter -> filter)
        .as(scalar[Long].single)

    }

    Page(null, page, offset, null)
    //Page(computers, page, offset, totalRows)
  }

  def insert(id: Long) = {
    db.withConnection { implicit connection =>
      SQL("delete computer where id = id")
        .on('id -> id)
        .executeUpdate()
    }
  }

  def update(id: Long, computer: Computer) = {
    db.withConnection { implicit connection =>
      SQL(
        """
          update computer
          set
            ,name = {name}
            ,introduced = {introduced}
            ,discontinued = {discontinued}
            ,company_id = {company_id}
          where id = id
        """.stripMargin)
        .on(
          'id -> id,
          'name -> computer.name,
          'introduced -> computer.introduced,
          'discontinued -> computer.discontinued,
          'company_id -> computer.companyId
        )
        .executeUpdate()
    }
  }

  def delete(id: Long) = {
    db.withConnection { implicit connection =>
      SQL("delete computer where id = id")
        .on('id -> id)
        .executeUpdate()
    }
  }

  def findById(id: Long): Option[Computer] = {
    db.withConnection { implicit connection =>
      SQL("select * from computer where id = {id}")
        .on('id -> id)
        .as(Computer.simple.singleOpt)
    }
  }

  def options: Seq[(String, String)] = {
    db.withConnection { implicit connection =>
      SQL("select * from company order by name")
        .as(Computer.simple *).map(c => c.id.toString -> c.name)
    }
  }*/
}

