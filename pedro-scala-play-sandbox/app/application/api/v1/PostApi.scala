package application.api.v1

import models.Person
import play.api.libs.json.Json
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}

import javax.inject.*

@Singleton
class PostApi @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def index: Action[AnyContent] = Action {
    val p1 = Person(age = 28, name = "John Doe")
    val p2 = Person(age = 15, name = "Jane Doe")
    val p3 = Person(age = 50, name = "Mary Jane")

    Ok(Json.toJson(List.apply(p1, p2, p3)))
  }
}
