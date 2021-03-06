type Stack = List[Int]

def pop(stack: Stack): (Int, Stack) = stack match {
  case x :: xs => (x, xs)
}

def push(a: Int, stack: Stack): (Unit, Stack) = ((), a :: stack)

def stackManip(stack: Stack): (Int, Stack) = {
  val (_, newStack1) = push(3, stack)
  val (a, newStack2) = pop(newStack1)
  pop(newStack2)
}

stackManip(List(5, 8, 2, 1)) println
