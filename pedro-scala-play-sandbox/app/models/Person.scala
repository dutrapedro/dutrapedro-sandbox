package models

import play.api.libs.json.{Json, OFormat}

case class Person(age: Int, name: String)

object Person {
  implicit val format: OFormat[Person] = {
    Json.format[Person]
  }
}
