package sections.section2

object Exercise452 extends App {
  object calc {
    def square(in: Double): Double = in * in
  }

  println(calc.square(5))
  println(calc.square(6))
}
