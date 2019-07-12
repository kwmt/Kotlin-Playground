package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    runBlocking {
        // this: CoroutineScope
        launch {
            // launch a new coroutine in the scope of runBlocking
            delay(1000L)
            println("World!")
        }
        println("Hello,")
    }
}