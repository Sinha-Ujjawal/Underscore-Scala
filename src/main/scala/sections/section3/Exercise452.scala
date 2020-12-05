package sections.section3

object Exercise452 extends App {
  case class Director(firstName: String, lastName: String, yearOfBirth: Int) {
    def name = s"$firstName $lastName"
  }
  object Director {
    def older(first: Director, second: Director): Director =
      if (first.yearOfBirth <= second.yearOfBirth) first else second
  }

  case class Film(
      name: String,
      yearOfRelease: Int,
      imdbRating: Double,
      director: Director
  ) {
    def directorsAge = yearOfRelease - director.yearOfBirth
    def isDirectedBy(otherDirector: Director) = otherDirector == director
  }

  object Film {
    def highestRating(first: Film, second: Film): Film =
      if (first.imdbRating >= second.imdbRating) first else second

    def oldestDirectorAtTheTime(first: Film, second: Film): Director = {
      if (first.directorsAge >= second.directorsAge) first.director
      else second.director
    }
  }
}
