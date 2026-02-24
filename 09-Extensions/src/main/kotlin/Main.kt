package m09_extensions

fun String.maskEmail(): String {
    val at = indexOf("@")
    if (at <= 1) return this
    return first() + "***" + substring(at)
}

class Account(private val email: String) {
    fun preview(): String = email.maskEmail()
}

fun main() {
    val raw = "dev@example.com"
    println(raw.maskEmail())

    // 注意：扩展函数不是类的真实成员，不能访问 private 字段。
    println(Account("owner@example.com").preview())
}
