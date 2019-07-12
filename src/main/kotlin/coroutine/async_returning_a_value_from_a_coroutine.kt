package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    val deferred = (1..1_000_000).map { n ->
        GlobalScope.async {
            delay(1000)
            n
        }
    }

    runBlocking {
        val sum = deferred.sumBy { it.await() }
        println("Sum: $sum")
    }
}