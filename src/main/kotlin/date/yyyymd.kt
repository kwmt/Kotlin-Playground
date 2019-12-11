package date

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun main() {
    val date = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日")
    println(date.format(formatter))

    (1..100).forEach{
        println(it%5)
    }
}