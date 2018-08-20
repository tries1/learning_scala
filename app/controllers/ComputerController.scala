package controllers

import javax.inject._
import play.api.data._
import play.api.data.Forms._
import models.Computer

import play.api.mvc.{AbstractController, ControllerComponents}
import services.ComputerService

@Singleton
class ComputerController @Inject()(cc: ControllerComponents
                              ,cs: ComputerService) extends AbstractController(cc){
  /*val home = Redirect(routes.ComputerController.list(0, 2, ""))

  def index = Action { home }

  val computerForm = Form(
    mapping(
      "id" -> ignored(None: Option[Long]),
      "name" -> nonEmptyText,
      "introduced" -> optional(date("yyyy-MM-dd")),
      "discontinued" -> optional(date("yyyy-MM-dd")),
      "company" -> optional(longNumber)
    )(Computer.apply)(Computer.unapply _)
  )

  def list(page: Int, orderBy: Int, filter: String) = Action { implicit request =>
      Ok(views.html.list(
        cs.list(page = page, orderBy = orderBy
          , filter= ("%" + filter + "%")), orderBy, filter
      ))
  }

  def edit(id: Long) = Action {
    cs.findById(id).map { computer =>
      Ok(views.html.editForm(id, computerForm.fill(computer), cs.options))
    }.getOrElse(NotFound)
  }

  def update(id: Long) = Action { implicit request =>
    computerForm.bindFromRequest.fold(
      formWithError =>
        BadRequest(views.html.editForm(id, formWithError, cs.options)),
      computer =>
        cs.update(id, computer)
        home.flashing("success" -> "Computer %s has been updated", format(computer.name))
    )
  }

  def create = Action {
    Ok(views.html.createForm(computerForm, cs.options))
  }

  def save = Action { implicit request =>
    computerForm.bindFromRequest.fold(
      formWithErrors =>
        BadRequest(views.html.createForm(formWithErrors, cs.options)),
      computer => {
        cs.insert(computer)
        home.flashing("success" -> "Computer %s has been created", format(computer.name))
      }
    )
  }

  def delete(id: Long) = Action {
    cs.delete(id)
    home.flashing("success" -> "Computer %s has been deleted")
  }*/
}
