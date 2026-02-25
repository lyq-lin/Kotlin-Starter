package m07_collections

// 本模块主题：集合（List / Map）与常见 API

fun top2Words(words: List<String>): List<Pair<String, Int>> =
    words
        .groupingBy { it }
        .eachCount()
        .entries
        .sortedByDescending { it.value }
        .take(2)
        .map { it.key to it.value }

fun main() {
    val logs = listOf("INFO", "WARN", "INFO", "ERROR", "INFO", "WARN")

    val upper = logs.map { it.uppercase() }
    val warnings = upper.filter { it.startsWith("W") }
    val uniqueLevels = upper.distinct().sorted()
    val errorCount = logs.count { it == "ERROR" }
    val totalChars = logs.fold(0) { acc, level -> acc + level.length }

    println("warnings=$warnings")
    println("uniqueLevels=$uniqueLevels")
    println("errorCount=$errorCount")
    println("totalChars=$totalChars")

    val idToName = mapOf(1 to "Alice", 2 to "Bob", 3 to "Carol")
    println("id=2 -> ${idToName[2]}")
    println("id=99 -> ${idToName.getOrDefault(99, "Unknown")}")

    val namesWithO = idToName.filterValues { it.contains("o", ignoreCase = true) }
    val greetingMap = idToName.mapValues { (_, name) -> "Hi, $name" }
    println("namesWithO=$namesWithO")
    println("greetingMap=$greetingMap")

    for ((id, name) in idToName) println("$id: $name")

    println("top2=${top2Words(logs)}")
}
