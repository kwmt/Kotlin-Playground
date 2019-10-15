package queue

import java.util.*

fun main() {
    val processes = ArrayDeque<String>(listOf("a", "b", "c"))
    println(processes.peek())
    println(processes)

    val profile= Profile("A", "B")
    println(profile.fullName())


    println(Account.fullName())
}

data class Profile(
    val firstName: String,
    val lastName: String
) {
    fun fullName() : String {
        return firstName + lastName
    }
}

class Account {

    companion object {

        // プロフィール情報は基本、登録・設定画面から設定しないと更新されないので、それ以外の画面ではキャッシュとして保持しておいたものを使う
        var profile: Profile? = null

        fun fullName(): String {
            return "${profile?.lastName}${profile?.firstName}"
        }
    }
}
