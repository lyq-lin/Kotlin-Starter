package m04_functions

fun greet(name: String, prefix: String = "Hi"): String = "$prefix, $name"

fun sum(vararg nums: Int): Int = nums.sum()

infix fun Int.times(text: String): String = text.repeat(this)

fun main() {
    println(greet("Kotlin"))
    println("sum=" + sum(1, 2, 3, 4))
    println(3 times "Go")
}
