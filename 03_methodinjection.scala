trait Monoid[A] {
  def mappend(a1: A, a2: A): A
  def mzero: A
}

def plus[A: Monoid](a: A, b: A): A = implicitly[Monoid[A]].mappend(a,b)

object Monoid {
  implicit val IntMonoid: Monoid[Int] = new Monoid[Int] {
    def mappend(a: Int, b: Int): Int = a + b
    def mzero: Int = 0
  }
}

trait MonoidOp[A] {
  val F: Monoid[A]
  val value: A
  def |+|(a2: A) = F.mappend(value, a2)
}

implicit def toMonoidOp[A: Monoid](a: A): MonoidOp[A] = new MonoidOp[A] {
  val F = implicitly[Monoid[A]]
  val value = a
}

println(plus(3,4))
