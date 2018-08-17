package services

import java.util.Date

import anorm.SqlParser._
import anorm._
import javax.inject.{Inject, Singleton}
import models.Member
import play.api.db.DBApi

@Singleton
class MemberService @Inject() (dbApi: DBApi) {
  private val db = dbApi.database("default")

  val basicMember = {
    get[Int]("member.mid") ~
    get[String]("member.userid") ~
    get[String]("member.password") ~
    get[String]("member.nickname") ~
    get[String]("member.email") ~
    get[Option[Date]]("member.regdate") map {
      case mid ~ userid ~ password ~ nickname ~ email ~ regdate =>
        Member(mid, userid, password, nickname, email, regdate)
    }
  }

  def getList = db.withConnection { implicit connection =>
    SQL("SELECT * FROM member").as(basicMember *)
  }

  def insert(member: Member) = {
    db.withConnection { implicit connection =>
      SQL(
        """
          insert into member (userid, password, nickname, email, regdate)
            values ({userid}, {password}, {nickname}, {email}, {regdate})
        """.stripMargin).on(
        'userid -> member.userid
        ,'password -> member.password
        ,'nickname -> member.nickname
        ,'email -> member.email
        ,'regdate -> member.regdate
      ).executeInsert()
    }
  }
}

