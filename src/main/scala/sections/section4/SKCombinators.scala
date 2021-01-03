package sections.section4

object SKCombinators extends App {
  def S[A, B, C] = (x: A => B => C) => (y: A => B) => (z: A) => x(z)(y(z))
  def K[A, B] = (x: A) => (y: B) => x

  def B[A, B, C] =
    S[B => C, A => B => C, (A => B) => (A => C)](
      K[(A => (B => C)) => ((A => B) => (A => C)), B => C](S[A, B, C])
    )(K)

  def I[A] = S(K[A, Any])(K[A, Any])
  def M[A] = (S(I[A => A])(I[A => A].asInstanceOf[(A => A) => A]))
    .asInstanceOf[(A => A) => A => A]

  // val composer = B[Int, Int, Int]((x: Int) => x * x)((x: Int) => x + 1)
  // println(composer(5))
  println(M(I[Int])(5))
}
