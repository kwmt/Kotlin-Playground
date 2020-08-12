package coroutine.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
receive: 1
receive: 2
receive: 3
receive: 4
receive: 5
done
 */
fun main() {

    runBlocking {
        val channel = Channel<Int>()

        launch {
            (1..5).forEach {
                channel.send(it)
            }
        }

        launch {
            repeat(5) {
                println("receive: ${channel.receive()}")
            }
            println("done")
        }
    }
}