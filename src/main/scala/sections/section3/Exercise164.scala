package sections.section3

object Exercise164 extends App {
  class Counter(val count: Int) {
    def inc = new Counter(count + 1)
    def dec = new Counter(count - 1)
    override def toString(): String = s"Counter(count=$count)"
  }

  println(
    new Counter(10).inc.dec.inc.inc
  ) // Should output 12 as (10 + 1 - 1 + 1 + 1 = 12)
}
