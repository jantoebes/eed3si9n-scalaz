case class TrafficLight(name: String)
val red = TrafficLight("red")
val yellow = TrafficLight("yellow")
val green = TrafficLight("green")

implicit val TrafficLightEqual: Equal[TrafficLight] = Equal.equal(_ == _)

red === yellow println
