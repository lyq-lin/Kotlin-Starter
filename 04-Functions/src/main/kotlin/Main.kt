package m04_functions

// 默认参数 + 单表达式函数
fun greet(name: String, prefix: String = "Hi"): String = "$prefix, $name"

// vararg: 允许传入不定数量参数
fun sum(vararg nums: Int): Int = nums.sum()

// infix: 支持“中缀写法”，可以写成 `3 times "Go"`，更接近自然语言。
// 这里的 this 就是“点号左边那个 Int”，也就是重复次数。
// 例如：3 times "Go" -> this=3 -> "GoGoGo"
infix fun Int.times(text: String): String = text.repeat(this)

// Unit 返回：表示“这个函数不返回业务结果”。
// 典型场景是打印日志、发通知、写文件等动作。
// 这些动作会影响外部环境，这类影响就叫“副作用”。
// 例如 log("done") 会在控制台打印一行文本，但不会给你一个计算结果。
fun log(message: String): Unit {
    println("[LOG] $message")
}

fun debug(message: String){
    println("[DEBUG] $message")
}

fun main() {
    // 具名参数：避免多参数时位置混淆
    println(greet(name = "Kotlin"))
    println(greet(name = "Dev", prefix = "Hello"))

    println("sum=" + sum(1, 2, 3, 4))

    // 和 "Go".repeat(3) 等价，只是写法更像一句话。
    println(3 times "Go")

    log("functions demo done")

    debug("functions demo done")
}
