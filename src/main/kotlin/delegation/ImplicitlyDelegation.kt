package delegation

fun main() {
    val person = Person(JackName(), LongDistanceRunner())
    println(person.name)
    person.run()
}

interface Nameble {
    var name: String
}

class JackName : Nameble {
    override var name: String = "Jack"
}

class LongDistanceRunner : Runnable {
    override fun run() {
        println("long")
    }
}

class Person(name: Nameble, private val runner: Runnable) : Nameble, Runnable {
    override fun run() {
        runner.run()
    }

    override var name: String = name.name


}