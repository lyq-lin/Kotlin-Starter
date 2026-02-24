package m09_extensions

fun String.maskEmail(): String {
    val at = indexOf("@")
    if (at <= 1) return this
    return first() + "***" + substring(at)
}

fun main() {
    println("dev@example.com".maskEmail())
}
