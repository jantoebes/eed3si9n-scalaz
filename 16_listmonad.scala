^(List(1,2,3), List(10,100,100)) {_ * _} println

List(3,4,5) >>= {x => List(x, -x)} println

for {
  n <- List(1,2)
  ch <- List('a','b')
} yield (n, ch) println

