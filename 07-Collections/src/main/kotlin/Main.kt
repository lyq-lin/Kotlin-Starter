package m07_collections

fun top2Words(words: List<String>): List<Pair<String, Int>> =
    words
        .groupingBy { it }
        .eachCount()
        .entries
        .sortedByDescending { it.value }
        .take(2)
        .map { it.key to it.value }

fun main() {
    // 1) List：有序，可重复。
    val logs = listOf("INFO", "WARN", "INFO", "ERROR", "INFO", "WARN")

    // 常见 List API：map / filter / distinct / sorted / count
    val upper = logs.map { it.uppercase() }
    val warnings = upper.filter { it.startsWith("W") }
    val uniqueLevels = upper.distinct().sorted()
    val errorCount = logs.count { it == "ERROR" }

    println("warnings=$warnings")
    println("uniqueLevels=$uniqueLevels")
    println("errorCount=$errorCount")

    // fold: 从左到右聚合
    val totalChars = logs.fold(0) { acc, level -> acc + level.length }
    println("totalChars=$totalChars")

    // 2) Map：键值对集合，key 通常唯一。
    val idToName = mapOf(1 to "Alice", 2 to "Bob", 3 to "Carol")

    // 常见 Map API：[] / getOrDefault / filterValues / mapValues
    println("id=2 -> ${idToName[2]}")
    println("id=99 -> ${idToName.getOrDefault(99, "Unknown")}")

    val namesWithO = idToName.filterValues { it.contains("o", ignoreCase = true) }
    val greetingMap = idToName.mapValues { (_, name) -> "Hi, $name" }

    println("namesWithO=$namesWithO")
    println("greetingMap=$greetingMap")

    for ((id, name) in idToName) {
        println("$id: $name")
    }

    println("top2=${top2Words(logs)}")
}
