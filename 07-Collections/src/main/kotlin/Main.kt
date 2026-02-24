package m07_collections

fun top2Words(words: List<String>): List<Pair<String, Int>> =
    words.groupingBy { it }.eachCount().entries.sortedByDescending { it.value }.take(2).map { it.key to it.value }

fun main() {
    val logs = listOf("INFO", "WARN", "INFO", "ERROR", "INFO", "WARN")
    println(top2Words(logs))
}
