package sections.section4

object Exercise562 extends App {
  //   Calculation
  // In the last section we created a Calculation data type like so:
  // sealed trait Calculation
  // final case class Success(result: Int) extends Calculation
  // final case class Failure(reason: String) extends Calculation
  // We’re now going to write some methods that use a Calculation to perform
  // a larger calculation. These methods will have a somewhat unusual shape—this
  // is a precursor to things we’ll be exploring soon—but if you follow the patterns
  // you will be fine.
  // Create a Calculator object. On Calculator define methods + and - that
  // accept a Calculation and an Int, and return a new Calculation. Here are
  // some examples
  // assert(Calculator.+(Success(1), 1) == Success(2))
  // assert(Calculator.-(Success(1), 1) == Success(0))
  // assert(Calculator.+(Failure("Badness"), 1) == Failure("Badness"))
  // Now write a division method that fails if the divisor is 0. The following tests
  // should pass. Note the behavior for the last test. This indicates “fail fast” behavior.
  // If a calculation has already failed we keep that failure and don’t process
  // any more data even if, as is the case in the test, doing so would lead to another
  // failure.
  // assert(Calculator./(Success(4), 2) == Success(2))
  // assert(Calculator./(Success(4), 0) == Failure("Division by zero"))
  // assert(Calculator./(Failure("Badness"), 0) == Failure("Badness"))

  sealed trait Calculation
  final case class Success(result: Int) extends Calculation
  final case class Failure(reason: String) extends Calculation

  object Calculator {
    val divByZeroFailure: Failure = Failure("Division by zero")

    def +(calculation: Calculation, b: Int): Calculation =
      calculation match {
        case Success(a) => Success(a + b)
        case _          => calculation
      }

    def -(calculation: Calculation, b: Int): Calculation =
      calculation match {
        case Success(a) => Success(a - b)
        case _          => calculation
      }

    def /(calculation: Calculation, b: Int): Calculation =
      calculation match {
        case Success(a) =>
          b match {
            case 0 => divByZeroFailure
            case _ => Success(a / b)
          }
        case _ => calculation
      }
  }

  assert(Calculator.+(Success(1), 1) == Success(2))
  assert(Calculator.-(Success(1), 1) == Success(0))
  assert(Calculator.+(Failure("Badness"), 1) == Failure("Badness"))
  assert(Calculator./(Success(4), 2) == Success(2))
  assert(Calculator./(Success(4), 0) == Failure("Division by zero"))
  assert(Calculator./(Failure("Badness"), 0) == Failure("Badness"))
}
