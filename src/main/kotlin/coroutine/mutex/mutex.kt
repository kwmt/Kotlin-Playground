package coroutine.mutex

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

val mutex = Mutex()
var counter = 0
//
//fun main() = runBlocking {
//    withContext(Dispatchers.Default) {
//        massiveRun {
//            // protect each increment with lock
//            if(mutex.tryLock()) {
//                counter++
//                mutex.unlock()
//            }
//        }
//    }
//    println("Counter = $counter")
//}

fun main() = runBlocking {
    repeat(100) { // Camera2から毎フレーム呼ばれるイメージ
        delay(60) // Camera2から毎フレーム呼ばれるイメージ
        println("before launch isLocked: ${mutex.isLocked}")
        if (mutex.tryLock()) {
            // Detectのイメージ
            launch {
                delay(1000)
                mutex.unlock()
                println("done isLocked: ${mutex.isLocked}")
            }
        }
    }
}
