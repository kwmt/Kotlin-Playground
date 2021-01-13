package thread

object Sync {
    val counter = Counter()
}

fun main() {
    val threads = Array<MyThread>(1000) {
        MyThread()
    }
    threads.forEach { it.start() }
    for (i in (0 until 1000)) {
        try {
            threads[i].join()
        } catch (e: InterruptedException) {
            println(e)
        }
    }
    println(Sync.counter.count)
}

class Counter {
    var count: Int = 0
    fun countUp() {
        synchronized(this) {
            print("[")
            val n = count
            print(".")
            count = n + 1
            print("]")
        }
    }
}

class MyThread : Thread() {
    override fun run() {
        Sync.counter.countUp()
    }
}