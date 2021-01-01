package sections.section4

object Exercise701 extends App {
  //  A Calculator
  // In this exercise we’ll implement a simple interpreter for programs containing
  // only numeric operations.
  // We start by defining some types to represent the expressions we’ll be operating
  // on. In the compiler literature this is known as an abstract syntax tree.
  // Our representation is:
  // • An Expression is an Addition, Subtraction, or a Number;
  // • An Addition has a left and right Expression;
  // • A Subtraction has a left and right Expression; or
  // • A Number has a value of type Double.
  // Now implement a method eval that converts an Expression to a Double.
  // Use polymorphism or pattern matching as you see fit. Explain your choice of
  // implementation method.
  // We’re now going to add some expressions that call fail: division and square
  // root. Start by extending the abstract syntax tree to include representations
  // for Division and SquareRoot.
  // Now we’re going to change eval to represent that a computation can fail.
  // (Double uses NaN to indicate a computation failed, but we want to be helpful
  // to the user and tell them why the computation failed.) Implement an appropriate
  // algebraic data type.

  sealed trait Result[T]
  final case class Failure[T](val message: String) extends Result[T]
  final case class Success[T](val value: T) extends Result[T]

  sealed trait Expression {
    val divByZero: Failure[Double] = Failure("Division by zero")
    val sqrtOfNegativeNumber: Failure[Double] = Failure(
      "Square root of negative number"
    )

    def eval: Result[Double] =
      this match {
        case Number(value) => Success(value)
        case Addition(left, right) =>
          left.eval match {
            case Failure(message) => Failure(message)
            case Success(lval) =>
              right.eval match {
                case Failure(message) => Failure(message)
                case Success(rval)    => Success(lval + rval)
              }
          }
        case Subtraction(left, right) =>
          left.eval match {
            case Failure(message) => Failure(message)
            case Success(lval) =>
              right.eval match {
                case Failure(message) => Failure(message)
                case Success(rval)    => Success(lval - rval)
              }
          }
        case Division(left, right) =>
          left.eval match {
            case Failure(message) => Failure(message)
            case Success(lval) =>
              right.eval match {
                case Failure(message) => Failure(message)
                case Success(rval) =>
                  rval match {
                    case 0 => divByZero
                    case _ => Success(lval / rval)
                  }
              }
          }
        case SquareRoot(expr) =>
          expr.eval match {
            case Failure(message) => Failure(message)
            case Success(value) =>
              value < 0 match {
                case true  => sqrtOfNegativeNumber
                case false => Success(Math.sqrt(value))
              }
          }
      }
  }
  final case class Number(val value: Double) extends Expression
  final case class Addition(left: Expression, right: Expression)
      extends Expression
  final case class Subtraction(left: Expression, right: Expression)
      extends Expression
  final case class Division(left: Expression, right: Expression)
      extends Expression
  final case class SquareRoot(expr: Expression) extends Expression

  assert(
    Addition(SquareRoot(Number(-1.0)), Number(2.0)).eval ==
      Failure("Square root of negative number")
  )
  assert(Addition(SquareRoot(Number(4.0)), Number(2.0)).eval == Success(4.0))
  assert(Division(Number(4), Number(0)).eval == Failure("Division by zero"))
}
