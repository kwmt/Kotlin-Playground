package kotlinfest

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@UseExperimental(ExperimentalContracts::class)
fun main() {

    run {

    }

    val x: Int

    add {
        x = 1
    }
    println(x)
}

@ExperimentalContracts
inline fun <R> add(block: () -> R) : R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return block()
}

