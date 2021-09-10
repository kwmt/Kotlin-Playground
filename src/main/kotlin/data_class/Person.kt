package data_class

data class Person(
    val name: String,
    val age: Int,
) {
    var hasCar = false
}

fun main() {
    val person1 = Person(name = "p1", age = 20)
    person1.hasCar = true

    println("person1: ${person1.hasCar}")
    val person2 = person1.copy(name = "p2", age = 30)
    println("person2: ${person2.hasCar}")
}


