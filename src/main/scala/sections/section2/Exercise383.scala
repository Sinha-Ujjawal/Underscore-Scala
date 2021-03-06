package sections.section2

object Exercise383 extends App {
  // What is the difference between the following literals? What is the type and value of each?
  def typeAndValueOfLiteral(literal: Any): Unit = {
    println(s"Type of $literal is ${literal.getClass()} and value is $literal")
  }

  val x = "Hello World!"
  val y = println("Hello world!")

  typeAndValueOfLiteral(x)
  typeAndValueOfLiteral(y)
}
