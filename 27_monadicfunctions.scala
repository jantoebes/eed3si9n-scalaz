(Some(9.some): Option[Option[Int]]).join println

List(List(1, 2, 3), List(4, 5, 6)).join println

"boom".left[Int].right[String].join println

List(1, 2, 3) filterM { x => List(true, false) } println
