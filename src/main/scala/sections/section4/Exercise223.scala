package sections.section4

object Exercise223 extends App {
  // Good Scala developers don’t just use types to model data. Types are a great
  // way to put artificial limitations in place to ensure we don’t make mistakes in
  // our programs. In this exercise we will see a simple (if contrived) example of
  // this—using types to prevent division by zero errors.
  // Dividing by zero is a tricky problem — it can lead to exceptions. The JVM has
  // us covered as far as floating point division is concerned but integer division is
  // still a problem:
  // 1.0 / 0.0
  // // res31: Double = Infinity
  // 1 / 0
  // // java.lang.ArithmeticException: / by zero
  // // ... 1024 elided
  // Let’s solve this problem once and for all using types!
  // Create an object called divide with an apply method that accepts two Ints
  // and returns DivisionResult. DivisionResult should be a sealed trait with
  // two subtypes: a Finite type encapsulating the result of a valid division, and
  // an Infinite type representing the result of dividing by 0.
  // Here’s some example usage:
  // val x = divide(1, 2)
  // // x: DivisionResult = Finite(0)
  // val y = divide(1, 0)
  // // y: DivisionResult = Infinite
  // Finally, write some sample code that calls divide, matches on the result, and
  // returns a sensible description.

  sealed trait DivisionResult
  final case class Finite(val result: Int) extends DivisionResult
  case object Infinite extends DivisionResult

  object divide {
    def apply(num: Int, den: Int): DivisionResult =
      den match {
        case 0 => Infinite
        case _ => Finite(num / den)
      }
  }

  println(divide(1, 0))
  println(divide(1, 4))
  println(divide(5, 2))
  println(divide(4, 0))
}
