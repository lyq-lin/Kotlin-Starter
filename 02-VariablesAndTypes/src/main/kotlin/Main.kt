package m02_variablesandtypes

// const val: 编译期常量，必须定义在顶层 / object / companion object 中。
const val APP_NAME: String = "Kotlin Starter"

fun main() {
    // val: 只读引用（不可重新赋值），但如果引用的是可变对象，对象内容依旧可变。
    val retries = 3

    // var: 可变引用（可以重新赋值），适合“状态会变化”的场景。
    var current = 0


    // 显式类型声明（也可依赖类型推断）。
    val timeoutMs: Long = 1_500L
    val enabled: Boolean = true

    while (current < retries) {
        current++
    }

    // 除了 val / var，还常见这些“变量相关能力”：
    // 1) 可空类型（String?）
    val nickname: String? = null

    // 2) 延迟初始化 lateinit（只能用于非空 var，且非基本类型）
    lateinit var runtimeToken: String
    runtimeToken = "token-abc"

    lateinit var list: List<String>

    // 3) lazy 委托属性（首次访问时才初始化，且默认线程安全）
    val expensiveConfig: String by lazy { "model=gpt-4o-mini" }

    println(
        "$APP_NAME retries=$current timeoutMs=$timeoutMs enabled=$enabled " +
            "nickname=${nickname ?: "ANON"} runtimeToken=$runtimeToken config=$expensiveConfig"
    )
}
