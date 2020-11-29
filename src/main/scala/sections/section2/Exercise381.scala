package sections.section2

object Exercise381 extends App {
  // What are the values and types of the following Scala literals?
  def typeAndValueOfLiteral(literal: AnyVal): Unit = {
    println(s"Type of $literal is ${literal.getClass()} and value is $literal")
  }

  typeAndValueOfLiteral(42)
  typeAndValueOfLiteral(true)
  typeAndValueOfLiteral(123L)
  typeAndValueOfLiteral(42.0)
}
