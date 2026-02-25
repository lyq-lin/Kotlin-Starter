package m09_extensions

// 本模块主题：扩展函数（为现有类型添加“看起来像成员”的能力）

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

    // 扩展函数不是类的真实成员，不能访问 private 字段。
    println(Account("owner@example.com").preview())
}
