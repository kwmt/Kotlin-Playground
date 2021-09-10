package pair

fun main() {
    val pairData = PairData("a1", "b1")
    println("${pairData.a}, ${pairData.b}")
    val (a, b) = PairData("a2", "b2")
    println("$a, $b")
}

data class PairData(
    val a: String,
    val b: String,
)