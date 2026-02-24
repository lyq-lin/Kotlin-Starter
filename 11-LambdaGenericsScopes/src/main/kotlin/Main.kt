package m11_lambdagenericsscopes

fun <T> firstOr(default: T, list: List<T>): T = list.firstOrNull() ?: default

fun main() {
    val scores = listOf(10, 20, 30)
    val doubled = scores
        .map { it * 2 }
        .filter { it >= 40 }
    println(doubled)

    // apply: 返回接收者本身，适合对象配置
    val config = mutableMapOf<String, String>().apply {
        put("model", "gpt-4o-mini")
        put("timeout", "1500")
    }

    // let: 返回 lambda 结果，适合“加工后输出”
    println(config.let { "model=${it["model"]}" })

    // also: 侧重附加动作（如日志），返回接收者
    val payload = listOf("a", "b", "c").also { println("size=${it.size}") }
    println(payload)

    println(firstOr(0, scores))
}
