package controllers

import javax.inject._
import models.Member
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._
import play.api.i18n._
import services.MemberService

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents
                              ,ms: MemberService) extends AbstractController(cc) with I18nSupport {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  /*def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }*/

  def list = Action {
    Ok(views.html.index(ms.getList))
  }

  val joinForm = Form(
    mapping(
      "mid" -> ignored(0),
      "userid" -> nonEmptyText,
      "password" -> nonEmptyText,
      "nickname" -> nonEmptyText,
      "email" -> nonEmptyText,
      "regdate" -> optional(date("yyyy-MM-dd"))
    )(Member.apply)(Member.unapply _)
  )

  def form = Action { implicit request =>
    Ok(views.html.form(joinForm))
  }

  def save = Action { implicit request =>
    val newJoinForm = joinForm.bindFromRequest()
    newJoinForm.fold(hasErrors => {
      println(hasErrors)
      Redirect(routes.HomeController.list)
    }, member => {
      ms.insert(member)
      Redirect(routes.HomeController.list)
    })
  }

  def file = Action { implicit request =>
    Ok(views.html.file())
  }

  def uploadFile = Action(parse.multipartFormData) { request =>
    request.body.file("file").map{ file =>
      import java.io.File
      val filename = file.filename
      file.ref.moveTo(new File(s"/tmp/files/$filename"))
      Ok("파일 업로드 완료")
    }.getOrElse{
      Redirect(routes.HomeController.list).flashing("error" -> "파일이 없습니다.")
    }
  }
}
