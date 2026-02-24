package m13_importantpatterns

class ExpensiveClient {
    init { println("ExpensiveClient init once") }
}

class Service {
    val client by lazy { ExpensiveClient() }
}

fun safeParseInt(raw: String): Result<Int> = runCatching { raw.toInt() }

fun main() {
    println(safeParseInt("12").getOrNull())
    println(safeParseInt("bad").exceptionOrNull()?.message)
    val service = Service()
    service.client
    service.client
}
