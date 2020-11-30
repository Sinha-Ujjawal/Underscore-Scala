package sections.section3

import sections.section3.Exercise161.Cat

object Exercise162 extends App {
  // Define an object ChipShop with a method willServe. This method should
  // accept a Cat and return true if the cat’s favourite food is chips, and false
  // otherwise.

  object ChipShop {
    def willServe(cat: Cat): Boolean = cat.food == "Chips"
  }

  val oswald = new Cat(name = "Oswald", color = "Black", food = "Milk")
  val henderson = new Cat(name = "Henderson", color = "Ginger", food = "Chips")
  val quentin =
    new Cat(name = "Quentin", color = "Tabby and white", food = "Curry")

  println(ChipShop willServe oswald) // equivalent to ChipShop.willServe(oswald)
  println(ChipShop willServe henderson)
  println(ChipShop willServe quentin)
}
