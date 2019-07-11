import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

fun main(args: Array<String>) {

    val user = User(age = 20)

    println(user.age)

    println("test")


    println(user::age.get())

    println(user::age.get())
//    println(user::.get())

    val kClass = User::class

    user.print(User::class)

}

fun <T : Any> T.print(type: KClass<T>) {
    type.memberProperties.forEach {
        println("${it.name}: ${it.get(this)}")
    }
}

data class User(val age: Int)
//
//val x = 1
//
//fun main() {
//    println(::x.get())
//    println(::x.name)
//}