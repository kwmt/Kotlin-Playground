package list

fun main() {
    val list = arrayOf("A", "B", "C")
    val result = list.reduce { acc, s ->
        println("$acc, $s")
        "-d $acc"}
    println(result)

    val r = list.joinToString(separator = " ", transform = {
        "-d '$it'"
    })
    println(r)
}