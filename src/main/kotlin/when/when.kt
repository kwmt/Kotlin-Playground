package `when`

fun main() {
    val type : Type? = null

    val result = when(type){
        Type.A -> "A"
        Type.B -> "B"
        null -> TODO()
    }
}
enum class Type {
    A,B
}