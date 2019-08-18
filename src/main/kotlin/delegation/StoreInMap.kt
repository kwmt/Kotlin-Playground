package delegation

fun main() {
    class User(map: Map<String, Any?>) {
        val name: String by map
        val age: Int by map
    }

    val user = User(
        mapOf(
            "name" to "John Doe",
            "age" to 25
        )
    )

    println(user.name)
    println(user.age)

    println(user.name.javaClass)
    println(user.age.javaClass)
}