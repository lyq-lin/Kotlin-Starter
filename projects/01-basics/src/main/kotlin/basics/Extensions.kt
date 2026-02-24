package basics

fun String.lastCharOrQuestionMark(): Char = this.lastOrNull() ?: '?'

fun demoExtensions() {
    val text = "Kotlin"
    val empty = ""
    println("[扩展函数] Kotlin=>${text.lastCharOrQuestionMark()}, empty=>${empty.lastCharOrQuestionMark()}")
}
