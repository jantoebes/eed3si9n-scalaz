val x = DList.unfoldr(10, {(x: Int) => if (x == 0) none else (x, x - 1).some })

x.toList println

unfold(10) { (x) => if (x == 0) none else (x, x-1).some }


