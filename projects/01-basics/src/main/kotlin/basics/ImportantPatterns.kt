package basics

/**
 * 我最想补充的点 1：Result + runCatching
 * 场景：业务层不希望把异常直接抛到上层，而是返回可组合的成功/失败结果。
 */
fun safeDivide(a: Int, b: Int): Result<Int> = runCatching {
    require(b != 0) { "b 不能为 0" }
    a / b
}

/**
 * 我最想补充的点 2：Sequence 惰性计算
 * 场景：大列表处理时，使用 Sequence 避免中间集合过多创建。
 */
fun firstLargeEven(numbers: Sequence<Int>): Int? {
    return numbers
        .filter { it % 2 == 0 }
        .map { it * 2 }
        .firstOrNull { it > 1_000 }
}

/**
 * 我最想补充的点 3：接口委托 + lazy
 * 场景：把横切逻辑（日志/通知）委托出去，配置/密钥使用 lazy 延迟加载。
 */
interface Sender {
    fun send(message: String)
}

class ConsoleSender : Sender {
    override fun send(message: String) {
        println("[Sender] $message")
    }
}

class NotificationService(private val delegate: Sender) : Sender by delegate {
    val token: String by lazy { "token-${System.currentTimeMillis()}" }

    fun notifyOrder(orderId: String) {
        send("order=$orderId token=$token")
    }
}

fun demoImportantPatterns() {
    val ok = safeDivide(10, 2)
    val bad = safeDivide(10, 0)

    val largeEven = firstLargeEven((1..1_000).asSequence())

    val service = NotificationService(ConsoleSender())
    service.notifyOrder("A1001")

    println("[重要模式] ok=${ok.getOrNull()}, bad=${bad.exceptionOrNull()?.message}, largeEven=$largeEven")
}
