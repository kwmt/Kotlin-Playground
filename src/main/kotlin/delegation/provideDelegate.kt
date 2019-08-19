package delegation

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class StringProvider {
    operator fun provideDelegate(
        thisRef: Main,
        prop: KProperty<*>
    ): ReadOnlyProperty<Main, String> = if (checkProperty(thisRef, prop.name)) {
        object : ReadOnlyProperty<Main, String> {
            override fun getValue(thisRef: Main, property: KProperty<*>): String {
                return "true string"
            }
        }
    } else {
        object : ReadOnlyProperty<Main, String> {
            override fun getValue(thisRef: Main, property: KProperty<*>): String {
                return "false string"
            }
        }
    }

    private fun checkProperty(thisRef: Main, name: String) = name.length > 4
}

fun bindString() = StringProvider()

class Main {
    val fake by bindString()
    val valid by bindString()
}

fun main(args: Array<String>) {
    Main().apply {
        println(fake) //false string
        println(valid) //true string
    }
}