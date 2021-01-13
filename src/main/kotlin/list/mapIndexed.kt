package list

fun main() {
    listOf("a").mapIndexed { index, s ->
        println(index)
    }

}