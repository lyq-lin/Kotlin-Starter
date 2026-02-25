package m08_nullsafety

// 本模块主题：空安全（可空类型、?.、?:、let、早返回）

fun parsePort(raw: String?): Int = raw?.toIntOrNull() ?: 8080

fun printUpperName(name: String?) {
    val nonNull = name ?: run {
        println("ANON")
        return
    }

    nonNull.let { println(it.uppercase()) }
}

fun main() {
    val fromEnv: String? = null
    println("port=${parsePort(fromEnv)}")

    val user: String? = "Tom"
    println("user length=${user?.length}")

    printUpperName(user)
    printUpperName(null)
}
