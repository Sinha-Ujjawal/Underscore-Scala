package sections.section3

object Exercise163 extends App {
  class Director(
      val firstName: String,
      val lastName: String,
      val yearOfBirth: Int
  ) {
    def name = s"$firstName $lastName"
    def ==(otherDirector: Director) =
      name == otherDirector.name && yearOfBirth == otherDirector.yearOfBirth

    override def toString(): String =
      s"Director(name=$name, yearOfBirth=$yearOfBirth)"
  }

  class Film(
      val name: String,
      val yearOfRelease: Int,
      val imdbRating: Double,
      director: Director
  ) {
    def directorsAge = yearOfRelease - director.yearOfBirth
    def isDirectedBy(otherDirector: Director) = otherDirector == director
    def copy(
        name: String = this.name,
        yearOfRelease: Int = this.yearOfRelease,
        imdbRating: Double = this.imdbRating,
        director: Director = this.director
    ) = new Film(
      name = name,
      yearOfRelease = yearOfRelease,
      imdbRating = imdbRating,
      director = director
    )
    override def toString(): String =
      s"Film(name=$name, yearOfRelease=$yearOfRelease, imdbRating=$imdbRating, director=$director)"
  }

  val nolan = new Director("Christopher", "Nolan", 1970)
  val memento = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
  val inception = new Film("Inception", 2010, 8.8, nolan)

  println(memento)
  println(memento.copy(name = "MOMENTO"))
  println(memento.copy().copy())
  println(darkKnight.isDirectedBy(nolan))
  println(darkKnight.directorsAge)
  println(memento.directorsAge)
}
