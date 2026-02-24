package m08_nullsafety

fun parsePort(raw: String?): Int = raw?.toIntOrNull() ?: 8080

fun main() {
    val fromEnv: String? = null
    println("port=" + parsePort(fromEnv))
    val user: String? = "Tom"
    println(user?.uppercase() ?: "ANON")
}
