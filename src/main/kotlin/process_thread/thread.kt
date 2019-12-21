package process_thread

import java.lang.Thread.sleep

fun main() {
    Thread {
        (0 until 26).forEach {
            println(it)
            sleep(1000)
        }
    }.start()


    val enStartHex = 0x61
    val enEndHex = enStartHex + 26
    (enStartHex until enEndHex).forEach {
        println(it.toChar())
        sleep(1500)
    }
}