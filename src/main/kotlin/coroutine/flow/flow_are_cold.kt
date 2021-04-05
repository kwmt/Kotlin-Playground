package coroutine.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun simple2() : Flow<Int>  = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

/**
 * Flowがcollectされるまでflow builderは実行されない => FlowはCold
 */
fun main() = runBlocking {
    println("Calling simple function...")
    val flow = simple2()

    println("Calling collect...")
    flow.collect { value -> println(value) }

    println("Calling collect again...")
    flow.collect { value -> println(value) }
}