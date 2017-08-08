def foldingFunction(list: List[Double], next: String): List[Double] = (list, next) match {
  case (x :: y :: ys, "*") => (y * x) :: ys
  case (x :: y :: ys, "+") => (y + x) :: ys
  case (x :: y :: ys, "-") => (y - x) :: ys
  case (xs, numString) => numString.toInt :: xs
}

def solveRPN(s: String): Double = 
  (s.split(' ').toList.foldLeft(Nil: List[Double]) {foldingFunction}).head

solveRPN("10 4 3 + 2 * -") println
 
