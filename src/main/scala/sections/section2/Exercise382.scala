package sections.section2

object Exercise382 extends App {
  // What is the difference between the following literals? What is the type and value of each?
  def typeAndValueOfLiteral(literal: Any): Unit = {
    println(s"Type of $literal is ${literal.getClass()} and value is $literal")
  }

  val x = 'a'
  val y = "a"

  typeAndValueOfLiteral(x)
  typeAndValueOfLiteral(y)
}
