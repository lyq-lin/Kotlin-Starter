package m08_nullsafety

fun parsePort(raw: String?): Int = raw?.toIntOrNull() ?: 8080

fun printUpperName(name: String?) {
    // 早返回：当数据不满足条件，尽早退出。
    val nonNull = name ?: run {
        println("ANON")
        return
    }

    // let: 只在非空时执行代码块
    nonNull.let { println(it.uppercase()) }
}

fun main() {
    val fromEnv: String? = null
    println("port=" + parsePort(fromEnv))

    val user: String? = "Tom"
    printUpperName(user)
    printUpperName(null)
}
