package process_thread

import java.util.concurrent.Executor
import java.util.concurrent.Executors

class ThreadPoolSample : Thread() {
    override fun run() {
        println("Thread:${Thread.currentThread().id}")
        sleep(1000)
    }
}

fun main() {
    val fixedThreadPool = Executors.newFixedThreadPool(5)
    (0..100).forEach {
        fixedThreadPool.execute(ThreadPoolSample())
    }
    fixedThreadPool.shutdown()

}