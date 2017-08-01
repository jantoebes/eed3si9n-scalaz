(1, 2, 3) map {_ + 1} println

val f = ((x: Int) => x + 1) map {_ * 7}
f(3) println

val g = Functor[List].lift {(_: Int) * 2}
g(List(3)) println

println (List(1, 2, 3) >| "x")
List(1, 2, 3).void println


