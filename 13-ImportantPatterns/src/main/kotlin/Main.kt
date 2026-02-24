package m13_importantpatterns

class ExpensiveClient {
    init {
        println("ExpensiveClient init once")
    }
}

class Service {
    // lazy: 首次访问才初始化，且同一个实例只初始化一次。
    val client by lazy { ExpensiveClient() }
}

fun safeParseInt(raw: String): Result<Int> = runCatching { raw.toInt() }

fun main() {
    // Result 链式处理：mapCatching + recover
    val parsed = safeParseInt("12")
        .mapCatching { it * 2 }
        .recover { -1 }
    println(parsed.getOrNull())

    val failed = safeParseInt("bad")
        .mapCatching { it * 2 }
        .recover { -1 }
    println(failed.getOrNull())

    val service = Service()
    service.client
    service.client
}
