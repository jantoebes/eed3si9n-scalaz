val f = List(1, 2, 3, 4) map {(_: Int) * (_: Int)}.curried

f map {_(9)} println

println (1.point[List])
println (1.pure[List])
println (1.point[Option] map {_ + 2})

println (9.some <*> {(_: Int) + 3}.some)
println (3.some <*> { 9.some <*> {(_: Int) + (_: Int)}.curried.some})
println ((3.some |@| 5.some) {_ + _})

println (List(1, 2, 3) <*> List((_: Int) * 0, (_: Int) + 100, (x: Int) => x * x))
println (List(3, 4) <*> { List(1, 2) <*> List({(_: Int) + (_: Int)}.curried, {(_: Int) * (_: Int)}.curried) })

println ((List("ha", "heh", "hmm") |@| List("?", "!", ".")) {_ + _})

val g = Apply[Option].lift2((_: Int) :: (_: List[Int]))
println (g(3.some, List(3).some))

def sequenceA[F[_]: Applicative, A](list: List[F[A]]): F[List[A]] = list match {
  case Nil     => (Nil: List[A]).point[F]
  case x :: xs => (x |@| sequenceA(xs)) {_ :: _}
}

println (sequenceA(List(1.some, 2.some)))
println (sequenceA(List(3.some, none, 1.some)))


