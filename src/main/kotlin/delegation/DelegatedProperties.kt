package delegation

import kotlin.reflect.KProperty


class Example {
    var p by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return property.name
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

fun main() {
    val example = Example()
    println(example.p)
    example.p = "NEW"
}


