package delegation

import kotlin.properties.Delegates


fun main() {
    class User {
        var name: String by Delegates.observable("<no name>") { property, oldValue, newValue ->
            println("$oldValue->$newValue")
        }
    }

    val user = User()
    println(user.name)
    user.name = "first"
    println(user.name)
    user.name = "second"
    println(user.name)

}