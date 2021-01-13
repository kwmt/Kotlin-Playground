package new1_4

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

val isEven = IntPredicate { it % 2 == 0 }
fun main() {
    println("Is 7 even? — ${isEven.accept(7)}")
}