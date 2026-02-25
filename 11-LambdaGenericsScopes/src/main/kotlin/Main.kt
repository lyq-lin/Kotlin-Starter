package m11_lambdagenericsscopes

// 本模块主题：Lambda + 泛型函数 + 作用域函数（let/apply/also）

fun <T> firstOr(default: T, list: List<T>): T = list.firstOrNull() ?: default

fun main() {
    val scores = listOf(10, 20, 30)
    val doubled = scores
        .map { it * 2 }
        .filter { it >= 40 }
    println(doubled)

    val config = mutableMapOf<String, String>().apply {
        put("model", "gpt-4o-mini")
        put("timeout", "1500")
    }

    println(config.let { "model=${it["model"]}" })

    val payload = listOf("a", "b", "c").also { println("size=${it.size}") }
    println(payload)

    println(firstOr(0, scores))
}
