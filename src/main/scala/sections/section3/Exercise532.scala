package sections.section3

object Exercise532 extends App {
  case class Director(firstName: String, lastName: String) {
    val name = s"$firstName $lastName"
  }

  case class Film(name: String, director: Director)

  object Dad {
    def rate(film: Film): Double =
      film.director.name match {
        case "Clint Eastwood" => 10.0
        case "John McTiernan" => 7.0
        case _                => 3.0
      }
  }

  val clint_eastwood = Director(firstName = "Clint", lastName = "Eastwood")
  val john_mctiernan = Director(firstName = "John", lastName = "McTiernan")
  val ujjawal_sinha = Director(firstName = "Ujjawal", lastName = "Sinha")

  val film1 = Film(name = "film1", director = clint_eastwood)
  val film2 = Film(name = "film2", director = john_mctiernan)
  val film3 = Film(name = "film3", director = ujjawal_sinha)

  println(
    Dad.rate(film = film1),
    Dad.rate(film = film2),
    Dad.rate(film = film3)
  )
}
