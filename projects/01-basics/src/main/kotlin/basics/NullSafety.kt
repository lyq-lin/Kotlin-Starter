package basics

/**
 * 场景：解析可选配置
 * 常见于从环境变量、YAML、JSON 读取可空值后进行兜底。
 */
fun parseTimeoutMs(raw: String?): Int {
    return raw
        ?.trim()
        ?.toIntOrNull()
        ?.takeIf { it > 0 }
        ?: 3_000
}

fun demoNullSafety() {
    val nullableName: String? = null
    val lengthOrZero = nullableName?.length ?: 0

    val timeout = parseTimeoutMs(" 5000 ")
    val fallbackTimeout = parseTimeoutMs("bad")

    println("[空安全] nullableName length=$lengthOrZero, timeout=$timeout, fallback=$fallbackTimeout")
}
