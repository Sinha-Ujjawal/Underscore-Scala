package sections.section3

object Exercise161 extends App {

  // +----+----+------+--------+-----+
  // |Name|    |Colour|        |Food |
  // +----+----+------+--------+-----+
  // Oswald    Black           Milk
  // Henderson Ginger          Chips
  // Quentin   Tabby and white Curry

  class Cat(val name: String, val color: String, val food: String) {
    override def toString(): String =
      s"Meow name is $name, my color is $color, and I like $food"
  }

  val oswald = new Cat(name = "Oswald", color = "Black", food = "Milk")
  val henderson = new Cat(name = "Henderson", color = "Ginger", food = "Chips")
  val quentin =
    new Cat(name = "Quentin", color = "Tabby and white", food = "Curry")

  println(oswald)
  println(henderson)
  println(quentin)

}
