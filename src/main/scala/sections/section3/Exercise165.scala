package sections.section3

object Exercise165 extends App {
  class Counter(val count: Int) {
    def inc(by: Int = 1) = new Counter(count + by)
    def dec(by: Int = 1) = inc(by = -by)
    override def toString(): String = s"Counter(count=$count)"
  }

  println(
    new Counter(10).inc().dec().inc().inc()
  ) // Should output 12 as (10 + 1 - 1 + 1 + 1 = 12)

  println(
    new Counter(10).inc(5).dec(6).inc(5).inc(5)
  ) // Should output 19 as (10 + 5 - 6 + 5 + 5 = 19)
}
