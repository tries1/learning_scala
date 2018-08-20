package services

import dao.UserDao
import scalaz.Scalaz._
import scalaz.ListT._
import models.UserSchema._
import javax.inject.Inject

import scala.concurrent.{ExecutionContext, Future}

class UserService @Inject()(userDao: UserDao)(implicit ec: ExecutionContext) {


  def getUsers: Future[Seq[UserRow]] = {
    val result = for {
      u <- listT(userDao.findByName("abc").map(_.toList))
    } yield UserRow(u.id, u.name, u.email)
    result.run
  }

  /*def getUsers: Future[Seq[UserRow]] = {
    val result = for {
      c <- listT(eventCardDao.findProgressEventCardsByEventType(EventCardType.KAKAOPAY.toString).map(_.toList))
      eventPeriod = s"${formatter.print(c.eventStartDttm)}-${formatter.print(c.eventEndDttm)}"
    } yield ProgressKakaoPayEventCard(c.id, c.eventTitle, c.eventType, c.partnerName, c.bannerProgressImage, c.bannerBgImage.getOrElse(""), c.bannerLandingUrl, c.bannerLandingType, eventPeriod)
    result.run
  }*/
}
