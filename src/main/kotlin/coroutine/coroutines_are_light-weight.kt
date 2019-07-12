package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args:  Array<String>) = runBlocking {
    repeat(100_000) {
        // threadにしてみたら、体感でthreadよりcoroutineの方が早いことがわかる
        launch {
            delay(1000L)
            println(".")
        }
    }
}