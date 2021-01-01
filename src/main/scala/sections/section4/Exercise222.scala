package sections.section4

object Exercise222 extends App {
  // Write a sealed trait Color to make our shapes more interesting.
  // • give Color three properঞes for its RGB values;
  // • create three predefined colours: Red, Yellow, and Pink;
  // • provide a means for people to produce their own custom Colors with
  // their own RGB values;
  // • provide a means for people to tell whether any Color is “light” or “dark”.
  // A lot of this exercise is let deliberately open to interpretation. The important
  // thing is to practice working with traits, classes, and objects.
  // Decisions such as how to model colours and what is considered a light or dark
  // colour can either be let up to you or discussed with other class members.
  // Edit the code for Shape and its subtypes to add a colour to each shape.
  // Finally, update the code for Draw.apply to print the colour of the argument
  // as well as its shape and dimensions:
  // • if the argument is a predefined colour, print that colour by name:
  // Draw(Circle(10, Yellow))
  // // res8: String = A yellow circle of radius 10.0cm
  // • if the argument is a custom colour rather than a predefined one, print
  // the word “light” or “dark” instead.
  // You may want to deal with the colour in a helper method.

  sealed trait Color {
    def R: Short
    def G: Short
    def B: Short

    def isDark: Boolean = (R + G + B) < (3 * 128)
    def isLight: Boolean = !isDark
  }
  case object Red extends Color {
    val R = 255
    val G = 0
    val B = 0
  }
  case object Green extends Color {
    val R = 0
    val G = 255
    val B = 0
  }
  case object Blue extends Color {
    val R = 0
    val G = 0
    val B = 255
  }
  case object Pink extends Color {
    val R = 255
    val G = 192
    val B = 203
  }
  final case class CustomColor(R: Short, G: Short, B: Short) extends Color

  println(Red.isDark, Red.isLight)
  println(Green.isDark, Green.isLight)
  println(Blue.isDark, Blue.isLight)
  println(Pink.isDark, Pink.isLight)

  val dark = CustomColor(R = 40, G = 30, B = 50)
  val light = CustomColor(R = 240, G = 230, B = 250)

  println(dark.isDark, dark.isLight)
  println(light.isDark, light.isLight)

  sealed trait Shape {
    def sides: Int
    def perimeter: Double
    def area: Double
    def color: Color
  }

  sealed trait Rectangular extends Shape {
    val sides: Int = 4
    def length: Double
    def bredth: Double
    val perimeter: Double = (length + bredth) * 4
    val area: Double = length * bredth
  }

  case class Circle(val radius: Double, val color: Color) extends Shape {
    val sides: Int = Int.MaxValue
    val perimeter: Double = 2 * math.Pi * radius
    val area: Double = math.Pi * radius * radius
  }

  final case class Rectangle(
      val length: Double,
      val bredth: Double,
      val color: Color
  ) extends Rectangular

  final case class Square(val side: Double, val color: Color)
      extends Rectangular {
    val length: Double = side
    val bredth: Double = side
  }

  object Draw {
    def apply(shape: Shape): String =
      shape match {
        case Circle(radius, color) =>
          s"A ${Draw(color)} circle with radius ${radius}cm"
        case Rectangle(length, bredth, color) =>
          s"A ${Draw(color)} rectangle with length ${length}cm and bredth ${bredth}cm"
        case Square(side, color) =>
          s"A ${Draw(color)} square with side ${side}cm"
      }

    def apply(color: Color): String =
      color match {
        case Red   => "Red"
        case Blue  => "Blue"
        case Green => "Green"
        case Pink  => "Pink"
        case _     => if (color.isDark) "Dark" else "Light"
      }
  }

  val circle2cmRed = Circle(radius = 2, color = Red)
  val circle2cmBlue = Circle(radius = 2, color = Blue)
  val circle2cmGreen = Circle(radius = 2, color = Green)
  val circle2cmPink = Circle(radius = 2, color = Pink)
  val circle2cmDark = Circle(radius = 2, color = dark)
  val circle2cmLight = Circle(radius = 2, color = light)

  val rectangle2by2Red = Rectangle(length = 2, bredth = 2, color = Red)
  val rectangle2by2Blue = Rectangle(length = 2, bredth = 2, color = Blue)
  val rectangle2by2Green = Rectangle(length = 2, bredth = 2, color = Green)
  val rectangle2by2Pink = Rectangle(length = 2, bredth = 2, color = Pink)
  val rectangle2by2Dark = Rectangle(length = 2, bredth = 2, color = dark)
  val rectangle2by2Light = Rectangle(length = 2, bredth = 2, color = light)

  val square2cmRed = Square(side = 2, color = Red)
  val square2cmBlue = Square(side = 2, color = Blue)
  val square2cmGreen = Square(side = 2, color = Green)
  val square2cmPink = Square(side = 2, color = Pink)
  val square2cmDark = Square(side = 2, color = dark)
  val square2cmLight = Square(side = 2, color = light)

  println(Draw(shape = circle2cmRed))
  println(Draw(shape = circle2cmBlue))
  println(Draw(shape = circle2cmGreen))
  println(Draw(shape = circle2cmPink))
  println(Draw(shape = circle2cmDark))
  println(Draw(shape = circle2cmLight))

  println(Draw(shape = rectangle2by2Red))
  println(Draw(shape = rectangle2by2Blue))
  println(Draw(shape = rectangle2by2Green))
  println(Draw(shape = rectangle2by2Pink))
  println(Draw(shape = rectangle2by2Dark))
  println(Draw(shape = rectangle2by2Light))

  println(Draw(shape = square2cmRed))
  println(Draw(shape = square2cmBlue))
  println(Draw(shape = square2cmGreen))
  println(Draw(shape = square2cmPink))
  println(Draw(shape = square2cmDark))
  println(Draw(shape = square2cmLight))
}
