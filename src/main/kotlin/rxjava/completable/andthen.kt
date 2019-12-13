package rxjava.completable

import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*

fun main() {

    val scope = MainScope()
    val c1 = Completable.create { emitter ->

//        scope.launch(Dispatchers.Default) {
//            delay(1000)
//            println("Completable 1-a")
//
//        }
        println("Completable 1-b")
        emitter.onComplete()
    }
    val c2 = Completable.create { emitter ->
//        scope.launch(Dispatchers.Default) {
//            println("Completable 2-a")
//            delay(500)
//
//        }
        println("Completable 2-b")
        emitter.onComplete()
    }

    c1.andThen{
        c2
    }.subscribe({
        println("Complete!")
    }, {
        println(it)
    })
}

