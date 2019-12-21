package process_thread

import java.lang.Thread.sleep

val lock = Any()

class SampleThread : Thread() {
    override fun run() {
        synchronized(lock) {
            (0 until 26).forEach {
                println(it)
                sleep(1000)
            }
        }
    }
}

fun main() {
    SampleThread().start()
    SampleThread().start()

}