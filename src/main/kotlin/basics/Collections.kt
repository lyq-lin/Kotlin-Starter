package basics

/**
 * 场景：日志记录聚合分析
 * - groupBy: 按日志级别分组
 * - mapValues: 统计每个级别数量
 * - sortedByDescending: 按出现次数排序
 */
fun topLogLevels(logs: List<String>): List<Pair<String, Int>> {
    return logs
        .groupBy { it.substringBefore(':') }
        .mapValues { (_, entries) -> entries.size }
        .toList()
        .sortedByDescending { it.second }
}

fun demoCollections() {
    val langs = listOf("Kotlin", "Java", "Python")
    val upper = langs.map { it.uppercase() }

    val scores = mutableMapOf("Alice" to 90, "Bob" to 85)
    scores["Cindy"] = 95

    val logs = listOf(
        "INFO:startup",
        "WARN:timeout",
        "INFO:healthcheck",
        "ERROR:db down",
        "WARN:retry",
    )

    println("[集合] upper=$upper, scores=$scores, topLevels=${topLogLevels(logs)}")
}
