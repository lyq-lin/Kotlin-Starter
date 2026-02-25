package m02_variablesandtypes

// 本模块主题：变量与类型（val/var、类型推断、可空类型、属性初始化策略）

// const val: 编译期常量，必须定义在顶层 / object / companion object 中。
const val APP_NAME: String = "Kotlin Starter"

class SessionHolder {
    // lateinit: 延迟初始化（非空 var，且不能是基本类型）
    lateinit var token: String
}

class Config {
    // lazy: 首次访问才初始化（默认线程安全）
    val endpoint: String by lazy { "https://example.com/api" }
}

fun main() {
    // val: 只读引用（引用不可重新赋值）
    val retries = 3

    // var: 可变引用（可重新赋值）
    var current = 0

    // 显式类型（也可省略，交给类型推断）
    val timeoutMs: Long = 1_500L
    val enabled: Boolean = true

    while (current < retries) current++

    // 可空类型：String? 表示允许为 null
    val nickname: String? = null
    val displayName = nickname ?: "ANON"

    val session = SessionHolder()
    session.token = "token-abc"

    val config = Config()

    println("$APP_NAME retries=$current timeoutMs=$timeoutMs enabled=$enabled")
    println("displayName=$displayName token=${session.token} endpoint=${config.endpoint}")
}
