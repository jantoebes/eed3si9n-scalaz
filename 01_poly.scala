// Parametric polymorphism: Parameter is the poly
def head[A](xs: List[A]): A= xs(0)

case class Car(make: String)

println(head(Car("Civic") :: Car("CR-V") :: Nil))

// Subtype polymorphism: Poly is passed to the subtypes
trait Plus[A] {
  def plus(a2: A): A
}

def plus[A <: Plus[A]](a1: A, a2: A): A = a1.plus(a2)

case class Dummy(value: Int) extends Plus[Dummy] {
  def plus(a2: Dummy): Dummy = Dummy(value + a2.value)
}

println(Dummy(4).plus(Dummy(6)))

// Adhoc polymorphism: Adding is separated from the case class
trait Plus2[A] {
  def plus(a1: A, a2: A): A
}

case class Dummy2(value: Int)

implicit object Dummy2Plus2 extends Plus2[Dummy2] {
  def plus(a1: Dummy2, a2: Dummy2) = Dummy2(a1.value + a2.value)
}

def plus[A: Plus2](a1: A, a2: A): A = implicitly[Plus2[A]].plus(a1, a2)

println(plus(Dummy2(2), Dummy2(3)))
