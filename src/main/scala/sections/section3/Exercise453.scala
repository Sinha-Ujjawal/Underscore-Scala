package sections.section3

object Exercise453 extends App {
  case class Counter(count: Int = 0) {
    def inc(by: Int = 1): Counter = Counter(count = count + by)
    def dec(by: Int = 1): Counter = inc(by = -by)
  }
}
