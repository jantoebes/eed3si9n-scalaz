functor.laws[List].check

sealed trait COption[+A] {}
case class CSome[A](counter: Int, a: A) extends COption[A]
case object CNone extends COption[Nothing]

implicit def coptionEqual[A]: Equal[COption[A]] = Equal.equalA
implicit val coptionFunctor = new Functor[COption] {
  def map[A, B](fa: COption[A])(f: A => B): COption[B] = fa match {
    case CNone => CNone
    case CSome(c, a) => CSome(c + 1, f(a))
  }
}

import org.scalacheck.{Gen, Arbitrary}
implicit def COptionArbiterary[A](implicit a: Arbitrary[A]): Arbitrary[COption[A]] = a map { a => (CSome(0, a): COption[A]) }

functor.laws[COption].check

semigroup.laws[Int @@ Tags.Multiplication].check
semigroup.laws[Int].check

