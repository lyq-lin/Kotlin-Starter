package m13_importantpatterns

// 本模块主题：常见模式（lazy、Result/runCatching）

class ExpensiveClient {
    init {
        println("ExpensiveClient init once")
    }
}

class Service {
    val client by lazy { ExpensiveClient() }
}

fun safeParseInt(raw: String): Result<Int> = runCatching { raw.toInt() }

fun main() {
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
