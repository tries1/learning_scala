package controllers

import javax.inject._
import models.UserSchema.UserRow
import org.json4s.DefaultFormats
import org.json4s.native.JsonMethods
import org.json4s.native.Serialization._
import play.api.mvc.{AbstractController, ControllerComponents}
import services.UserService

import scala.concurrent.ExecutionContext

@Singleton
class UserController @Inject()(cc: ControllerComponents, us: UserService)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  //using import play.api.libs.json._
  /*implicit val format = Json.writes[UserRow]
  def getUser() = Action.async {
    //us.getUsers("abc").map { users => Ok(users) }

    for {
      users <- us.getUsers("abc")
    } yield Ok(Json.toJson(users))
  }*/

  //using json4 native
  implicit val formats = DefaultFormats
  def getUser() = Action.async {
    //us.getUsers("abc").map { users => Ok(users) }

    for {
      users <- us.getUsers("abc")
      result = println(users)
      //} yield Ok(Json.toJson(users))
    } yield Ok(write(users))
  }

  def save = Action { request =>
    val json = request.body.asJson.get.toString()
    println("json : " + json)
    val user1 = read[UserRow](json)
    var user2 = JsonMethods.parse(json).extract[UserRow]
    //Json.parse(jsonString).as[Map[String, String]]

    println(json, user1, user2)
    us.save(user1)

    Ok("saved")
  }


  // 소상공인 이벤트 응모 api
  /*
  def saveSmallBizEvent = (LoggingAction andThen kakaoPayAuthFilteredAction).async { request =>
    val accountId = request.kakaoAccount.get.accountId
    val talkSession = request.kakaoAccount.get.talkSession
    val data = request.body
    val jsonString:String = data.asJson.fold("")(_.toString)

    for {
      res <- moneyApiService.saveSmallBizEvent(baseSmallBizEventPapi, talkSession, accountId, jsonString)
      result = res.body
    } yield JsonResult.success()
  }
  */
}
