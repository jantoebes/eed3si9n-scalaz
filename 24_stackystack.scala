type Stack = List[Int]

def stackyStack: State[Stack, Unit] = for {
  stackNow <- get
  r <- if (stackNow === List(1, 2, 3)) put (List(8, 3, 1))
       else put(List(9, 2, 1))
} yield r

stackyStack(List(1, 2, 3)) println

val pop: State[Stack, Int] = for {
  s <- get[Stack]
  val (x :: xs) = s
  _ <- put(xs)
} yield x

def push(x: Int): State[Stack, Unit] = for {
  xs <- get[Stack]
  r <- put(x :: xs)
} yield r


