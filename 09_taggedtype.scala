case class KiloGram(value: Double)
def KiloGram[A](a: A): A @@ KiloGram = Tag[A, KiloGram](a)

val mass = KiloGram(20.0)

2 * Tag.unwrap(mass)
