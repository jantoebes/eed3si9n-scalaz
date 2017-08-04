def lengthCompare(lhs: String, rhs: String): Ordering =
  (lhs.length ?|? rhs.length) |+| (lhs ?|? rhs)

lengthCompare ("zen", "ants") println

lengthCompare("zen", "ant") println
