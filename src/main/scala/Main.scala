object Main extends App {
  def greet(name: String = ""): String =
    if (name.nonEmpty) s"hello $name" else "hello"
}
