trait CanTruthy[A] {
  def truthys(a: A): Boolean
}

object CanTruthy {
  def truthys[A](f: A => Boolean): CanTruthy[A] = new CanTruthy[A] {
    def truthys(a: A): Boolean = f(a)
  }
}

trait CanTruthyOps[A] {
  def self: A
  def F: CanTruthy[A]
  final def truthy: Boolean = F.truthys(self)
}

object ToCanIsTruthyOps {
  implicit def toCanIsTruthyOps[A](v: A)(implicit ev: CanTruthy[A]) =
    new CanTruthyOps[A] {
      def self = v
      def F: CanTruthy[A] = ev
    }
}

import ToCanIsTruthyOps._

implicit val intCanTruthy: CanTruthy[Int] = CanTruthy.truthys({
  case 0 => false
  case _ => true
})

implicit def listCanTruthy[A]: CanTruthy[List[A]] = CanTruthy.truthys({
  case Nil => false
  case _   => true
})

implicit val booleanCanTruthy: CanTruthy[Boolean] = CanTruthy.truthys(identity)

10.truthy println

List("foo").truthy println

false.truthy println

// Conditional truthy statement
def truthyIf[A: CanTruthy, B](cond: A)(ifyes: => B)(ifno: => B) =
  if (cond.truthy) ifyes
  else ifno

truthyIf (2 :: Nil) {"YEAH!"} {"NO!"} println
