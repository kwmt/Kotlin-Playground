package coroutine

import kotlinx.coroutines.*

fun main(args: Array<String>) {
    println("Start")

    GlobalScope.launch {
        // lancement de la coroutine
        delay(1000L) // suspension de la coroutine pendant 1 seconde
        println("World!")
    }
    println("Hello,") // le thread principal continue tant que la coroutine est suspendue
    runBlocking {
        delay(2000L) // suspension de la coroutine pendant 1 seconde
        println("runblockin!")
    }

}