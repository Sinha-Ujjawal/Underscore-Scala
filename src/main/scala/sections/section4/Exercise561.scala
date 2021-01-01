package sections.section4

object Exercise561 extends App {
  //   Traffic Lights
  // In the previous section we implemented a TrafficLight data type like so:
  // sealed trait TrafficLight
  // case object Red extends TrafficLight
  // case object Green extends TrafficLight
  // case object Yellow extends TrafficLight
  // Using polymorphism and then using pattern matching implement a method
  // called next which returns the next TrafficLight in the standard Red ->
  // Green -> Yellow -> Red cycle. Do you think it is better to implement this
  // method inside or outside the class? If inside, would you use pattern matching
  // or polymorphism? Why?

  object NextUsingPolymorphism {
    sealed trait TrafficLight {
      def next: TrafficLight
    }
    case object Red extends TrafficLight {
      def next: TrafficLight = Green
    }
    case object Green extends TrafficLight {
      def next: TrafficLight = Yellow
    }
    case object Yellow extends TrafficLight {
      def next: TrafficLight = Red
    }
    def test: Unit = {
      assert(Red.next == Green)
      assert(Green.next == Yellow)
      assert(Yellow.next == Red)
    }
  }

  object NextUsingPatternMatchingOutside {
    sealed trait TrafficLight
    case object Red extends TrafficLight
    case object Green extends TrafficLight
    case object Yellow extends TrafficLight
    object NextTrafficLight {
      def apply(trafficLight: TrafficLight): TrafficLight =
        trafficLight match {
          case Red    => Green
          case Green  => Yellow
          case Yellow => Red
        }
    }
    def test: Unit = {
      assert(NextTrafficLight(Red) == Green)
      assert(NextTrafficLight(Green) == Yellow)
      assert(NextTrafficLight(Yellow) == Red)
    }
  }

  object NextUsingPatternMatchingWithinTrait {
    sealed trait TrafficLight {
      def next: TrafficLight =
        this match {
          case Red    => Green
          case Green  => Yellow
          case Yellow => Red
        }
    }
    case object Red extends TrafficLight
    case object Green extends TrafficLight
    case object Yellow extends TrafficLight

    def test: Unit = {
      assert(Red.next == Green)
      assert(Green.next == Yellow)
      assert(Yellow.next == Red)
    }
  }

  NextUsingPolymorphism.test
  NextUsingPatternMatchingOutside.test
  NextUsingPatternMatchingWithinTrait.test
}
