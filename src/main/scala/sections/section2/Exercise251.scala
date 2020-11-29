package sections.section2

object Exercise251 extends App {
  // Operator Style

  println("Rewrite in operator-style")
  println("foo".take(1))
  println("foo" take 1)

  println("Rewrite in method call style")
  println(1 + 2 + 3)
  println(1.+(2).+(3))
}
