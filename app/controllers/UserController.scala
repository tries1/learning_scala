package controllers

import javax.inject._
import play.api.mvc.{AbstractController, ControllerComponents}
import services.UserService

@Singleton
class UserController @Inject()(cc: ControllerComponents, us: UserService) extends AbstractController(cc) {

  def getUser() = Action.async {
    us.getUsers("abc") map { users => Ok(users) }
  }

  /*def getUser(name: String) = Action {
    for {
      Seq(progressKakaoPayEventCards, progressPartnerEventCards, closedEventCards) <- Future.sequence(Seq(
        service.getProgressKakaoPayEventCards,
        service.getProgressPartnerEventCards,
        service.getClosedEventCards
      ))
      progressResult = Map("kakaopay" -> progressKakaoPayEventCards, "partner" -> progressPartnerEventCards)
      result = status match {
        case None => Map("progress" -> progressResult, "closed" -> closedEventCards)
        case Some("PROGRESS") => Map("progress" -> progressResult)
        case Some("CLOSED") => Map("closed" -> closedEventCards)
        case Some(_) => throw InvalidEventStatusError
      }
    } yield JsonResult.success(result, snakeCase = true)
  }*/
}
