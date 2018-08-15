package models

import java.util.Date
import java.util.Calendar

case class Member(mid: Int, userid: String, password: String
                  , nickname: String, email: String, regdate: Option[Date])

object Member {
  def getList = {
    members
  }

  var date = Option.apply(Calendar.getInstance().getTime)
  var members = Set(
     Member(1, "admin", "admin", "admin", "admin@google.com", date)
    ,Member(2, "user1", "user1", "user1", "user1@google.com", date)
    ,Member(3, "user2", "user2", "user2", "user2@google.com", date)
    ,Member(4, "user3", "user3", "user3", "user3@google.com", date)
  )
}