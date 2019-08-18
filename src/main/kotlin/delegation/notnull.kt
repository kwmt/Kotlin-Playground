package delegation

import kotlin.properties.Delegates


lateinit var a: String

fun main() {
    var max: Int by Delegates.notNull()
//    println(max)

    max = 10
    println(max)
}