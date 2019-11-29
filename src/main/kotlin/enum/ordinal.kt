package enum

fun main() {
    println("Item.ordinal:${Type.Item.ordinal}")
    println("Footer.ordinal:${Type.Footer.ordinal}")
}

enum class Type {
    Item,
    Footer
}