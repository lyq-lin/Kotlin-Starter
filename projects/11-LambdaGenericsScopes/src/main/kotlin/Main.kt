fun <T> firstOr(default: T, list: List<T>): T = list.firstOrNull() ?: default

fun main() {
    val scores = listOf(10, 20, 30)
    val doubled = scores.map { it * 2 }.filter { it >= 40 }
    println(doubled)

    val config = mutableMapOf<String, String>().apply {
        put("model", "gpt-4o-mini")
        put("timeout", "1500")
    }
    println(config.let { "model=${it["model"]}" })
    println(firstOr(0, emptyList()))
}
