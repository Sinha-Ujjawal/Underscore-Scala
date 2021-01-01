package sections.section4

object Exercise443 extends App {
  //   Water, Water, Everywhere
  // Bottled water has a size (an Int), a source (which is a well, spring, or tap), and
  // a Boolean carbonated. Implement this in Scala.
  sealed trait WaterSource
  final case object Well extends WaterSource
  final case object Spring extends WaterSource
  final case object Tap extends WaterSource

  case class BottledWater(
      val size: Int,
      val source: WaterSource,
      carbonated: Boolean
  )

  println(BottledWater(100, Well, false))
  println(BottledWater(100, Tap, false))
  println(BottledWater(100, Spring, true))
  println(BottledWater(10, Spring, true))
}
