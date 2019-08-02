package calc

import kotlin.math.floor

fun main(args: Array<String>) {

    val differentSecond = -
    99

    val div = differentSecond / 10
    println(div)
    println(div is Int)
    val ans = floor((differentSecond / 10).toDouble()).toInt()
    println(ans)
}