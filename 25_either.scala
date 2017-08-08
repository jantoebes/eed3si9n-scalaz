1.right[String] println

"error".left[Int] println

println (for {
  e1 <- "event 1 ok".right
  e2 <- "event 2 failed!".left[String]
  e3 <- "event 3 failed1".left[String]
} yield (e1 |+| e2 |+| e3))

println ("event 1 ok".right map {_ + "!"})
println ("event 1 failed!".left ||| "retry event 1 ok".right)
