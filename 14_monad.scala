// Bind's contract
3.some flatMap { x => (x + 1).some } println

Monad[Option].point("WHAT") println

9.some flatMap { x => Monad[Option].point(x * 10) } println

(none: Option[Int]) flatMap { x => Monad[Option].point(x * 10) }


