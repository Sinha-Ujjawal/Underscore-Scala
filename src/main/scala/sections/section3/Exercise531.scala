package sections.section3

object Exercise531 extends App {
  // Define an object ChipShop with a method willServe. This method should
  // accept a Cat and return true if the cat’s favourite food is chips,
  // and false otherwise. Use pattern matching.

  case class Cat(name: String, color: String, food: String)
  object ChipShop {
    def willServe(cat: Cat): Boolean =
      cat.food match {
        case "chips" => true
        case _       => false
      }
  }

  val oswald = Cat(name = "Oswald", color = "black", food = "milk")
  val oggy = Cat(name = "Oggy", color = "blue", food = "chips")

  println(ChipShop willServe oswald)
  println(ChipShop willServe oggy)
}
