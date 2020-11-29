import org.scalatest.flatspec.AnyFlatSpec

class MainSpec extends AnyFlatSpec {
  "Main.greet" should "evaluates to \"hello\"" in {
    assert(Main.greet() == "hello")
  }

  "Main.greet(\"Ujjawal\")" should "evaluates to \"hello Ujjawal\"" in {
    assert(Main.greet("Ujjawal") == "hello Ujjawal")
  }
}
