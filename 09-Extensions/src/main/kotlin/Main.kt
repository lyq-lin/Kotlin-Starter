package m09_extensions

fun String.maskEmail(): String {
    val at = indexOf("@")

    // 扩展函数里的 this 指“调用者本身”。
    // 例如 raw.maskEmail() 里，this 就是 raw 这个字符串。
    // 邮箱太短时直接返回原文，所以下面 return this 就是“返回原始邮箱”。
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
