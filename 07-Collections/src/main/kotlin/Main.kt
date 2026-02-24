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
    val logs = listOf("INFO", "WARN", "INFO", "ERROR", "INFO", "WARN")

    // map + filter
    val onlyWarnings = logs.map { it.uppercase() }.filter { it.startsWith("W") }

    val m = mapOf<Int, String>(1 to "hello", 2 to "world")

    for ((index,word) in m) {
        println("$index: $word")
    }

    // fold: 从左到右聚合
    val totalChars = logs.fold(0) { acc, level -> acc + level.length }

    println(top2Words(logs))
    println("warnings=$onlyWarnings")
    println("totalChars=$totalChars")
}
