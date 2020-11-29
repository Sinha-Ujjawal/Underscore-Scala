package sections.section2

object Exercise141 extends App {
  // Using the Scala console or worksheet, determine the type and value of the
  // following expressions:

  // 1 + 2
  val x = 1 + 2
  println(s"Type of 1 + 2 is ${x.getClass()}")
  println(s"Value of 1 + 2 is $x")

  // "3".toInt
  val y = "3".toInt
  var expr = "\"3\".toInt"
  println(s"Type of $expr is ${y.getClass()}")
  println(s"Value of $expr is $y")

  // "foo".toInt
  val z = "foo".toInt
  expr = "\"foo\".toInt"
  println(s"Type of $expr is ${z.getClass()}")
  println(s"Value of $expr is $z")
}
