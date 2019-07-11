package coroutine

import kotlinx.coroutines.*

fun main(args: Array<String>) {
    launch { // lancement de la coroutine
        delay(1000L) // suspension de la coroutine pendant 1 seconde
        println("World!")
    }
    println("Hello,") // le thread principal continue tant que la coroutine est suspendue
    Thread.sleep(2000L) // suspension du thread principal pendant 2 secondes pour conserver la JVM en exécution (pour attendre la fin de la coroutine)
}