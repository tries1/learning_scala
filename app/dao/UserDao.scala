package dao

import javax.inject._
import models.UserSchema._
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserDao @Inject()(implicit ec: ExecutionContext) {
  lazy val db = Database.forConfig("db")

  def findByName(name: String): Future[Seq[UserRow]] = {
    val q = User.filter(u => u.name === name).sortBy(_.name).result
    db.run(q)
  }
}
