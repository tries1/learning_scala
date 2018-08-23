package dao

import org.joda.time.DateTime
import javax.inject._
import models.UserSchema._
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserDao @Inject()(implicit ec: ExecutionContext) {
  lazy val db = Database.forConfig("slick.dbs.default.db")

  def findByName(name: String): Future[Seq[UserRow]] = {
    val q = User.filter(u => u.name === name).sortBy(_.name).result
    db.run(q)
  }

  def save(row: UserRow): Future[Int] = {
    db.run(User += row)
  }
}
