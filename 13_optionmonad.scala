(none: Option[String]) |+| "andy".some println

(Ordering.LT: Ordering).some |+| none println

Tags.First('a'.some) |+| Tags.First('b'.some) println

Tags.Last('a'.some) |+| Tags.Last('b'.some) println

List(1, 2, 3).foldRight (1) { _ * _ } println

println (Tags.Conjunction(true) |+| Tags.Conjunction(false))

println (Tags.Disjunction(true) |+| Tags.Disjunction(false))

