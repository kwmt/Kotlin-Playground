package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    GlobalScope.launch {
        repeat(1000) {
            println("I'm sleeping $it ...")
            delay(500L)
        }
    }
    delay(1300L)
}