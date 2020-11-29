package sections.section2

object Exercise252 extends App {
  // What is the difference between the following expressions? What are the similarities?
  val x = 1 + 2 + 3
  val y = 6

  println("""
    The expressions have the same result type and return value. However, they
arrive at their results in different ways. The first computes its result through a
series of additions, while the later is simply a literal.

As neither expression has any side-effects, they are interchangeable from a
user's point of view. Anywhere you can write 1 + 2 + 3 you can also write
6, and vice versa, without changing the meaning of any program. This is known
as substitution and you may remember the principle from simplifying algebraic
formulae at school.

As programmers we must develop a mental model of how our code operates.
The substitution model of evaluation is a particularly simple model that says anywhere
we see an expression we may substitute its result. In the absence of
side-effects, the substitution model always works. If we know the types and
values of each component of an expression, we know the type and value of the
expression as a whole. In functional programming we aim to avoid side-effects
for this reason: it makes our programs easier to understand.
    """)
}
