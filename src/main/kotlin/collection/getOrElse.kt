package collection

fun main() {

    val list = listOf(
        User("a"),
        User("b"),
        User("c")
    )

    println(list.getOrElse(2) {
        User("d")
    }.name)
    println(list.getOrElse(3) {
        User("d")
    }.name)

}

data class User(val name: String)