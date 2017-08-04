List(1,2,3) mappend List(4,5,6) println

List(1,2,3) |+| List(4,5,6) println

Monoid[List[Int]].zero println

println (Tags.Multiplication(10) |+| Monoid[Int @@ Tags.Multiplication].zero)

10 |+| 2 println

println (Tags.Disjunction(true) |+| Tags.Disjunction(false))

