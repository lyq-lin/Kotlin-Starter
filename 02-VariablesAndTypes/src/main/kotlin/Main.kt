package m02_variablesandtypes

const val APP_NAME: String = "Kotlin Starter"

fun main() {
    // 场景：定义配置与状态
    val retries = 3
    var current = 0
    val timeoutMs: Long = 1500
    val enabled: Boolean = true

    while (current < retries) current++
    println("$APP_NAME retries=$current timeoutMs=$timeoutMs enabled=$enabled")
}
