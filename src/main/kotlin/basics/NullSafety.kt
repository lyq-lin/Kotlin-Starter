package basics

fun demoNullSafety() {
    val nullableName: String? = null
    val lengthOrZero = nullableName?.length ?: 0

    println("[空安全] nullableName length=$lengthOrZero")
}
