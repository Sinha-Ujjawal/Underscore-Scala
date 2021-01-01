package sections.section4

object Exercise141 extends App {
  // Demand for Cat Simulator 1.0 is exploding! For v2 we’re going to go beyond
  // the domestic cat to model Tigers, Lions, and Panthers in addition to the Cat.
  // Define a trait Feline and then define all the different species as subtypes of
  // Feline. To make things interesting, define:
  // • on Feline a colour as before;
  // • on Feline a String sound, which for a cat is "meow" and is "roar" for all other felines;
  // • only Cat has a favourite food; and
  // • Lions have an Int maneSize.

  // trait Feline {
  //   def name: String
  //   def color: String
  //   val sound: String = "roar"
  // }

  // case class Tiger(val name: String, val color: String) extends Feline
  // case class Lion(val name: String, val color: String, maneSize: Int)
  //     extends Feline
  // case class Panther(val name: String, val color: String) extends Feline
  // case class Cat(val name: String, val color: String) extends Feline {
  //   override val sound: String = "meow"
  // }
  // not considered a good practice to give default implementation, if it could be changed
  // by subtypes, it should be something that is common to all the subtypes

  trait Feline {
    def name: String
    def color: String
    def sound: String
  }

  case class Cat(val name: String, val color: String) extends Feline {
    val sound: String = "meow"
  }

  trait BigCat extends Feline {
    val sound: String = "roar"
  } // yes you can inherit trait from trait

  case class Tiger(val name: String, val color: String) extends BigCat
  case class Lion(val name: String, val color: String, maneSize: Int)
      extends BigCat
  case class Panther(val name: String, val color: String) extends BigCat
}
