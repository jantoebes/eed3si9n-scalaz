val g = (_: Int) + 3

g(4) println

val f = ({(_: Int) * 2} |@| {(_: Int) + 10}) { _ + _}

f(3) println

val addStuff: Int => Int = for {
  a <- (_:Int) * 2
  b <- (_:Int) + 10
} yield a + b

addStuff(3) println
