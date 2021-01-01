package sections.section4

object Exercise702 extends App {
  // JSON
  // In the calculator exercise we gave you the algebraic data type representation.
  // In this exercise we want you to design the algebraic data type yourself. We’re
  // going to work in what is hopefully a familiar domain: JSON.
  // Design an algebraic data type to represent JSON. Don’t go directly to code.
  // Start by sketching out the design in terms of logical ands and ors—the building
  // blocks of algebraic data types. You might find it useful to use a notation similar
  // to BNF. For example, we could represent the Expression data type from the
  // previous exercise as follows:
  // Expression ::= Addition left:Expression right:Expression
  // | Subtraction left:Expression right:Expression
  // | Division left:Expression right:Expression
  // | SquareRoot value:Expression
  // | Number value:Int
  // This simplified notation allows us to concentrate on the structure of the algebraic
  // data type without worrying about the intricacies of Scala syntax.
  // Note you’ll need a sequence type to model JSON, and we haven’t looked at
  // Scala’s collection library yet. However we have seen how to implement a list
  // as an algebraic data type.
  // Here are some examples of JSON you’ll need to be able to represent
  // ["a string", 1.0, true]
  // {
  // "a": [1,2,3],
  // "b": ["a","b","c"]
  // "c": { "doh":true, "ray":false, "me":1 }
  // }

  // JSON ::= Leaf[value: AnyVal]
  // | Seq[head: JSON, tail: Seq | SeqEnd]
  // | KV[key: String, value: JSON, tail: KV | KVEnd]

  sealed trait Json {
    def toStringSequence(seq: Seq): String = {
      def toStringSequenceUtil(seq: JsonSeq, acc: String = ""): String =
        seq match {
          case SeqEnd => acc
          case Seq(head, tail) =>
            toStringSequenceUtil(
              tail,
              if (acc.isEmpty) s"$head" else s"$acc, $head"
            )
        }
      toStringSequenceUtil(seq)
    }

    def toStringKV(kv: KV): String = {
      def toStringKVUtil(kv: JsonKV, acc: String = ""): String =
        kv match {
          case KVEnd => acc
          case KV(key, value, tail) =>
            toStringKVUtil(
              tail,
              if (acc.isEmpty) s""""$key": $value"""
              else s"""$acc, "$key": $value"""
            )
        }
      toStringKVUtil(kv)
    }

    override def toString(): String =
      this match {
        case LeafNull           => "null"
        case LeafBoolean(value) => value.toString
        case LeafDouble(value)  => value.toString
        case LeafInt(value)     => value.toString
        case LeafString(value)  => s""""$value""""

        case SeqEnd          => ""
        case Seq(head, tail) => s"[${toStringSequence(Seq(head, tail))}]"

        case KVEnd                => ""
        case KV(key, value, tail) => s"{${toStringKV(KV(key, value, tail))}}"
      }
  }

  sealed trait NonEmptyJson extends Json
  sealed trait EmptyJson extends Json

  sealed trait JsonValue[T] extends NonEmptyJson
  final case class LeafString(value: String) extends JsonValue[String]
  final case class LeafDouble(value: Double) extends JsonValue[Double]
  final case class LeafInt(value: Int) extends JsonValue[Int]
  final case class LeafBoolean(value: Boolean) extends JsonValue[Boolean]
  final case object LeafNull extends JsonValue[Nothing]

  sealed trait JsonSeq extends Json
  final case object SeqEnd extends JsonSeq with EmptyJson
  final case class Seq(head: NonEmptyJson, tail: JsonSeq)
      extends JsonSeq
      with NonEmptyJson

  sealed trait JsonKV extends Json
  final case object KVEnd extends JsonKV with EmptyJson
  final case class KV(key: String, value: NonEmptyJson, tail: JsonKV)
      extends JsonKV
      with NonEmptyJson

  val listOfPeople = Seq(
    head = KV(
      key = "Name",
      value = LeafString("Ujjawal Sinha"),
      tail = KV(
        key = "DOB",
        value = LeafInt(24),
        tail = KV(
          key = "Year of graduation",
          value = LeafInt(2019),
          tail = KVEnd
        )
      )
    ),
    tail = Seq(
      head = KV(
        key = "Name",
        value = LeafString("Saumya Raj"),
        tail = KV(
          key = "DOB",
          value = LeafNull,
          tail = KVEnd
        )
      ),
      tail = SeqEnd
    )
  )

  println(
    Seq(
      head = listOfPeople,
      tail = Seq(
        head = listOfPeople,
        tail = Seq(
          head = Seq(
            head = KV(
              key = "Haha",
              value = LeafNull,
              tail = KVEnd
            ),
            tail = SeqEnd
          ),
          tail = SeqEnd
        )
      )
    )
  )
}
