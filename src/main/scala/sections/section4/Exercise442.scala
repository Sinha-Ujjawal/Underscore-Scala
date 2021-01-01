package sections.section4

object Exercise442 extends App {
  //   Calculator
  // A calculation may succeed (with an Int result) or fail (with a String message).
  // Implement this.

  sealed trait Calculation
  final case class Success(val result: Int) extends Calculation
  final case class Fail(val message: String) extends Calculation
}
