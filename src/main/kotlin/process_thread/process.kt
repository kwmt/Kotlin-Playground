package process_thread

fun main() {
    val builder = ProcessBuilder("sleep", "100")
    val process = builder.start()
    val inputStream = process.inputStream
    while (true) {
        val c = inputStream.read()
        if (c == -1) {
            inputStream.close()
            break
        }
        print(c.toChar())
    }
}

