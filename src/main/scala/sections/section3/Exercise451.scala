package sections.section3

object Exercise451 extends App {
  // Recall that a Cat has a String colour and food. Define a case class to represent a Cat.
  case class Cat(name: String, colour: String, food: String)
  // yeah, that's it, this class has all the goodies
  // you can access name, colour and food using .attr syntax
  // you can use == to check object equality based on fields (in this case- name, colour and food)
  // have a beautiful toString representation
  // all of this comes out of the box
  // So embrace case class

  val oswald = Cat(name = "Oswald", colour = "Black", food = "Milk")
  val oggy = Cat(name = "Oggy", colour = "Blue", food = "Milk")
  println(oswald)
  println(oswald.name, oswald.food, oswald.colour)
  println(oswald == oswald)
  println(oswald == oggy)
  println(oggy == oggy)
}
