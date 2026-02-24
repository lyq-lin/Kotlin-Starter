package basics

fun greet(user: String): String = "你好, $user"

fun sum(a: Int, b: Int = 10): Int = a + b

fun String.toSlug(): String = lowercase().replace(" ", "-")

fun demoFunctions() {
    val title = "Kotlin CLI Starter"
    println(
        "[函数] ${greet("同学")} | sum(5)=${sum(5)} | sum(5,8)=${sum(5, 8)} | slug=${title.toSlug()}"
    )
}
