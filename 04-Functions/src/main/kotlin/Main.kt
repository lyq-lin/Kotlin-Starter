package m04_functions

// 本模块主题：函数定义与常见语法（默认参数、具名参数、vararg、infix、Unit）

fun greet(name: String, prefix: String = "Hi"): String = "$prefix, $name"

fun sum(vararg nums: Int): Int = nums.sum()

infix fun Int.times(text: String): String = text.repeat(this)

fun log(message: String): Unit {
    println("[LOG] $message")
}

fun debug(message: String) {
    println("[DEBUG] $message")
}

fun main() {
    println(greet(name = "Kotlin"))
    println(greet(name = "Dev", prefix = "Hello"))

    println("sum=" + sum(1, 2, 3, 4))
    println(3 times "Go")

    log("functions demo done")
    debug("functions demo done")
}
