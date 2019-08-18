package delegation

import java.lang.IllegalArgumentException
import kotlin.properties.Delegates


fun main() {
    var max: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
        if (newValue > oldValue) true else throw IllegalArgumentException("New value must be larger than old value.")
    }
    println(max)
    max = 10
    println(max)
    max = 5
}