package sections.section4

object Exercise441 extends App {
  // Stop on a Dime
  // A traffic light is red, green, or yellow. Translate this descrip􀦞on into Scala code.
  sealed trait TrafficLight
  final case object Red extends TrafficLight
  final case object Green extends TrafficLight
  final case object Yellow extends TrafficLight
}
