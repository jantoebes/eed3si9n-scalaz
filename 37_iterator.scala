Monoid[Int].applicative.ap2(1, 1)(0) println

Monoid[List[Int]].applicative.ap2(List(1), List(1))(Nil) println

Applicative[List].product[Option].point(1) println

((List(1), 1.some) |@| (List(1), 1.some)) {_ |+| _} println

Applicative[List].compose[Option].point(1) println

List(1,2,3) traverse { x => (x > 0) option (x + 1) } println

Monoid[Int].applicative.traverse(List(1,2,3)) {_+1} println

def contents[F[_]: Traverse, A](f: F[A]): List[A] = 
  Monoid[List[A]].applicative.traverse(f) {List(_)}

contents(List(1,2,3)) println

contents('P'.node('O'.leaf, 'L'.leaf)) println

List(1.some, 2.some).sequence println

List(1.some, 2.some, none).sequence println

