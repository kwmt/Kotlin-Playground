package tostring

import java.io.Serializable

fun main() {

    val list = listOf(
        Standard("a", "1"),
        Standard("b", "2")
    )

    val s = list.joinToString("\n") {
        "${it.prefix}: ${it.value}"
    }
    println(s)

}

data class Standard(
    val prefix: String,
    val value: String
)
