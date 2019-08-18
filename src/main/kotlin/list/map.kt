package list

fun main() {
    val list = listOf(
        1,
        2,
        3,
        4,
        5
    )
    val amount = 3
    val i = list.withIndex().map {
//        val index = it.index + 1
        if(amount in 1..2) {
            it.value
        } else if(amount in 4..5) {
            6
        } else {
            7
        }
    }.first()

    println(i)
}