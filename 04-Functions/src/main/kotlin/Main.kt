package m04_functions

// 默认参数 + 单表达式函数
fun greet(name: String, prefix: String = "Hi"): String = "$prefix, $name"

// vararg: 允许传入不定数量参数
fun sum(vararg nums: Int): Int = nums.sum()

// infix: 中缀调用（可读性更像 DSL）
infix fun Int.times(text: String): String = text.repeat(this)

// Unit 返回：用于只有副作用的函数
fun log(message: String): Unit {
    println("[LOG] $message")
}

fun main() {
    // 具名参数：避免多参数时位置混淆
    println(greet(name = "Kotlin"))
    println(greet(name = "Dev", prefix = "Hello"))

    println("sum=" + sum(1, 2, 3, 4))
    println(3 times "Go")

    log("functions demo done")
}
