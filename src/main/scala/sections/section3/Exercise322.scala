package sections.section3

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

object Director {
  def apply(firstName: String, lastName: String, yearOfBirth: Int): Director =
    new Director(
      firstName = firstName,
      lastName = lastName,
      yearOfBirth = yearOfBirth
    )

  def older(first: Director, second: Director): Director =
    if (first.yearOfBirth <= second.yearOfBirth) first else second
}

class Film(
    val name: String,
    val yearOfRelease: Int,
    val imdbRating: Double,
    val director: Director
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

object Film {
  def apply(
      name: String,
      yearOfRelease: Int,
      imdbRating: Double,
      director: Director
  ): Film =
    new Film(
      name = name,
      yearOfRelease = yearOfRelease,
      imdbRating = imdbRating,
      director = director
    )

  def highestRating(first: Film, second: Film): Film =
    if (first.imdbRating >= second.imdbRating) first else second

  def oldestDirectorAtTheTime(first: Film, second: Film): Director = {
    if (first.directorsAge >= second.directorsAge) first.director
    else second.director
  }
}

object Exercise322 extends App {
  val nolan = Director("Christopher", "Nolan", 1970)
  val memento = Film("Memento", 2000, 8.5, nolan)
  val darkKnight = Film("Dark Knight", 2008, 9.0, nolan)
  val inception = Film("Inception", 2010, 8.8, nolan)

  val me = Director("Ujjawal", "Sinha", 1998)
  val film1 = Film("Film1", 2010, 0, me)
  val film2 = Film("Film2", 2015, 3, me)

  println(Director.older(nolan, me))
  println(Film.highestRating(inception, film1))
  println(Film.highestRating(darkKnight, inception))
  println(Film.highestRating(film1, film2))
  println(Film.oldestDirectorAtTheTime(memento, film1))
}
