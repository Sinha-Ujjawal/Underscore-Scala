package sections.section4

object Exercise143 extends App {
  // The solution from the last exercise delivered three distinct types of shape.
  // However, it doesn’t model the relationships between the three correctly. A
  // Square isn’t just a Shape—it’s also a type of Rectangle where the width and
  // height are the same.
  // Refactor the solution to the last exercise so that Square and Rectangle are
  // subtypes of a common type Rectangular.
  // Tip: A trait can extend another trait.

  trait Shape {
    def sides: Int
    def perimeter: Double
    def area: Double
  }

  sealed trait Rectangular extends Shape {
    val sides: Int = 4
    def length: Double
    def bredth: Double
    def perimeter: Double = (length + bredth) * 4
    def area: Double = length * bredth
  }

  case class Circle(val radius: Double) extends Shape {
    val sides: Int = Int.MaxValue
    val perimeter: Double = 2 * math.Pi * radius
    val area: Double = math.Pi * radius * radius
  }

  final case class Rectange(val length: Double, val bredth: Double)
      extends Rectangular

  final case class Square(val side: Double) extends Rectangular {
    val length: Double = side
    val bredth: Double = side
  }
}
