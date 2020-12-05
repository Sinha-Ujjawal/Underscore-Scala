package sections.section3

object Exercise321 extends App {
  // Implement a companion object for Person containing an apply method that
  // accepts a whole name as a single string rather than individual first and last
  // names.

  class Person(val firstName: String, val lastName: String) {
    def ==(other: Person): Boolean =
      firstName == other.firstName && lastName == other.lastName
  }
  object Person {
    def apply(name: String): Person = {
      val parts = name.split(" ")
      new Person(firstName = parts(0), lastName = parts(1))
    }
  }

  assert(
    Person("Ujjawal Sinha") == new Person(
      firstName = "Ujjawal",
      lastName = "Sinha"
    )
  )

  assert(
    Person("ujjawal Sinha") == new Person(
      firstName = "ujjawal",
      lastName = "Sinha"
    )
  )

  assert(
    Person("John Doe") == new Person(
      firstName = "John",
      lastName = "Doe"
    )
  )

  assert(
    Person.apply("Ujjawal Sinha") == Person("Ujjawal Sinha")
  )

}
