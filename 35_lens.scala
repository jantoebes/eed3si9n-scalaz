case class Point(x: Double, y: Double)

case class Color(r: Byte, g: Byte, b: Byte)

case class Turtle(
  position: Point,
  heading: Double,
  color: Color)

val turtlePosition = Lens.lensu[Turtle, Point] (
  (a, value) => a.copy(position = value),
  _.position
)

val pointX = Lens.lensu[Point, Double](
  (a, value) => a.copy(x = value),
  _.x
)

val turtleX = turtlePosition >=> pointX

val t0 = Turtle(Point(2.0, 3.0), 0.0, Color(255.toByte, 255.toByte, 255.toByte))

turtleX.get(t0) println

println (turtleX.set(t0, 5.0))

println (turtleX.mod(_ + 1.0, t0))

val incX2 = turtleX =>= {_ + 1.0}

println (incX2(t0))

val incX = for {
  x <- turtleX %= {_ + 1.0}
} yield x

val turtleHeading = Lens.lensu[Turtle, Double] (
  (a, value) => a.copy(heading = value),
  _.heading
)

val pointY = Lens.lensu[Point, Double] (
  (a, value) => a.copy(y = value),
  _.y
)

val turtleY = turtlePosition >=> pointY

def forward(dist: Double) = for {
  heading <- turtleHeading
  x <- turtleX += dist * math.cos(heading)
  y <- turtleY += dist * math.sin(heading)
} yield (x, y)

println (forward(10.0)(t0))
println (forward(10.0) exec (t0))
