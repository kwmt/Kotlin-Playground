package operator

fun main() {
    val useCase = UseCase()
    val id = useCase("testid")
    println(id)

    val a = useCase.invoke("testid")
    println(a)
}

class UseCase {
    operator fun invoke(id: String): String {
        return id
    }
}