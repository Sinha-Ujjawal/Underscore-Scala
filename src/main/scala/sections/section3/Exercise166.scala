package sections.section3

object Exercise166 extends App {
  class Adder(amount: Int) {
    def add(in: Int) = in + amount
  }

  class Counter(val count: Int) {
    def inc(by: Int = 1) = new Counter(count + by)
    def dec(by: Int = 1) = inc(by = -by)
    def adjust(adder: Adder) = new Counter(adder.add(in = count))
    override def toString(): String = s"Counter(count=$count)"
  }

  val counter = new Counter(count = 10)
  val adder5 = new Adder(amount = 5)
  val adder10 = new Adder(amount = 10)
  println(counter.adjust(adder = adder5)) // should result to 15
  println(counter.adjust(adder = adder10)) // should result to 20
}
