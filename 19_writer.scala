def isBigGang(x: Int): (Boolean, String) = 
  (x > 9, "Compared gang size to 9.")

implicit class PairOps[A, B : Monoid](pair: (A, B)) {
  def applyLog[C](f: A => (C, B)): (C, B) = {
    val (x, log) = pair
    val (y, newLog) = f(x)
    (y, log |+| newLog)
  }
}

(3, "Smallish gang.") applyLog isBigGang println

3.set("Smallish gang.") println

"something".tell println

def logNumber(x: Int): Writer[List[String], Int] = 
  x.set(List("Got number: " + x.shows))

def multWithLog: Writer[List[String], Int] = for {
  a <- logNumber(3)
  b <- logNumber(5)
} yield a * b

println (multWithLog run)
