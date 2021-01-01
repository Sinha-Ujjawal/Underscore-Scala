package sections.section4

object Exercise221 extends App {
  // First make Shape a sealed trait. Then write a singleton object called Draw with
  // an apply method that takes a Shape as an argument and returns a descripঞon
  // of it on the console. For example:
  // Draw(Circle(10))
  // // res1: String = A circle of radius 10.0cm
  // Draw(Rectangle(3, 4))
  // // res2: String = A rectangle of width 3.0cm and height 4.0cm
  // Finally, verify that the compiler complains when you comment out a case
  // clause.
  sealed trait Shape {
    def sides: Int
    def perimeter: Double
    def area: Double
  }

  sealed trait Rectangular extends Shape {
    val sides: Int = 4
    def length: Double
    def bredth: Double
    val perimeter: Double = (length + bredth) * 4
    val area: Double = length * bredth
  }

  case class Circle(val radius: Double) extends Shape {
    val sides: Int = Int.MaxValue
    val perimeter: Double = 2 * math.Pi * radius
    val area: Double = math.Pi * radius * radius
  }

  final case class Rectangle(val length: Double, val bredth: Double)
      extends Rectangular

  final case class Square(val side: Double) extends Rectangular {
    val length: Double = side
    val bredth: Double = side
  }

  object Draw {
    def apply(shape: Shape): String =
      shape match {
        case Circle(radius) => s"A circle with radius ${radius}cm"
        case Rectangle(length, bredth) =>
          s"A rectangle with length ${length}cm and bredth ${bredth}cm"
        case Square(side) => s"A square with side ${side}cm"
      }
  }

}
