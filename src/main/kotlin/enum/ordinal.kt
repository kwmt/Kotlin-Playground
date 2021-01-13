package enum

fun main() {
    println("Item.ordinal:${Type.Item.ordinal}")
    println("Footer.ordinal:${Type.Footer.ordinal}")

    val v = enumValues<Type>()
    println(v)
}

enum class Type {
    Item,
    Footer
}