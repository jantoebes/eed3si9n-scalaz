type Birds = Int

case class Pole(left: Birds, right: Birds) {
  def landLeft(n: Birds): Option[Pole] = 
    if (math.abs((left + n) - right) < 4) copy(left = left + n).some
    else none
  def landRight(n: Birds): Option[Pole] =
    if (math.abs(left - (right + n)) < 4) copy(right = right + n).some
    else none
}

println (Monad[Option].point(Pole(0, 0)) flatMap {_.landRight(2)} flatMap {_.landLeft(2)} flatMap {_.landRight(2)})
println (Monad[Option].point(Pole(0, 0)) >>= {_.landRight(2)} >>= {_.landLeft(2)} >>= {_.landRight(2)})

println (3.some >> 4.some)
println (3.some >>= { x => (none: Option[String]) >>= { y => (x.shows + y).some } })

for {
  x <- 3.some
  y <- "!".some
} yield (x.shows + y) println

def routine: Option[Pole] = 
  for {
    start <- Monad[Option].point(Pole(0,0))
    first <- start.landLeft(2)
    second <- first.landRight(2)
    third <- second.landLeft(1)
  } yield third

println (routine)

