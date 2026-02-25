package m08_nullsafety

// 本模块主题：空安全（可空类型、?.、?:、let、run）

fun parsePort(raw: String?): Int = raw?.toIntOrNull() ?: 8080

fun printUpperName(name: String?) {
    val nonNull = name ?: run {
        println("ANON")
        return
    }

    nonNull.let { println(it.uppercase()) }
}

fun readEnvOrPrompt(
    envName: String,
    prompt: String,
    readInput: () -> String
): String {
    // 你提到的语法糖：
    // System.getenv(envName) ?: run { println(prompt); readln() }
    // 含义：如果环境变量为空，就执行 run 代码块作为兜底值。
    return System.getenv(envName) ?: run {
        println(prompt)
        readInput()
    }
}

fun main() {
    val fromEnv: String? = null
    println("port=${parsePort(fromEnv)}")

    val user: String? = "Tom"
    println("user length=${user?.length}")

    printUpperName(user)
    printUpperName(null)

    // 在本仓库示例里用 lambda 模拟 readln()，避免运行时阻塞。
    val apiKey = readEnvOrPrompt("DEMO_API_KEY", "请输入 API Key:") { "mock-key-from-input" }
    println("apiKey=$apiKey")
}
