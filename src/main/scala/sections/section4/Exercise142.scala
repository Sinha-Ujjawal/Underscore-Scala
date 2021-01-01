package sections.section4

object Exercise142 extends App {
  //  Define a trait called Shape and give it three abstract methods:
  // • sides returns the number of sides;
  // • perimeter returns the total length of the sides;
  // • area returns the area.
  // Implement Shape with three classes: Circle, Rectangle, and Square. In
  // each case provide implementations of each of the three methods. Ensure that
  // the main constructor parameters of each shape (e.g. the radius of the circle)
  // are accessible as fields.
  // Tip: The value of π is accessible as math.Pi.

  trait Shape {
    def sides: Int
    def perimeter: Double
    def area: Double
  }

  case class Circle(val radius: Double) extends Shape {
    val sides: Int = Int.MaxValue
    val perimeter: Double = 2 * math.Pi * radius
    val area: Double = math.Pi * radius * radius
  }

  case class Rectange(val length: Double, val bredth: Double) extends Shape {
    val sides: Int = 4
    val perimeter: Double = (length + bredth) * 2
    val area: Double = length * bredth
  }

  case class Square(val side: Double) extends Shape {
    val sides: Int = 4
    val perimeter: Double = side * 4
    val area: Double = side * side
  }
}
