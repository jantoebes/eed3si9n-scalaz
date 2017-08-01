import $ivy.`org.scalaz::scalaz-core:7.2.7`, scalaz._, Scalaz._

// Testing equalities
println (1===1)
println (1.some === 2.some)
println (1.some =/= 2.some)

// Testing order
println (1 gt 2)
println (1 ?|? 2)
println (1 max 2)

// Testing show
println (3.show)
println (3.shows)
"hello" println

// Testing enum
println ('a' to 'e')
println ('a' |-> 'e')
println ('B'.succ)

// Testing bounded
println (implicitly[Enum[Char]].min)
println (implicitly[Enum[Int]].min)
