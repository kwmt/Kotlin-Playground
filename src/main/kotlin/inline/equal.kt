package inline

inline class MyClass(val value: Int) {
    // Generated by the compiler:
    // public static final boolean equals-impl0(int p1, int p2) {
    //   return p1 == p2;
    // }
}
fun main() {
    val first = MyClass(1)
    val second = MyClass(1)
    println(first == second)
    // Called under the hood:
    // MyClass.equals-impl0(first, second)
}

