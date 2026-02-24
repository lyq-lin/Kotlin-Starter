package basics

open class Person(val name: String, var age: Int) {
    open fun profile(): String = "$name($age)"
}

class Student(name: String, age: Int, val major: String) : Person(name, age) {
    override fun profile(): String = "${super.profile()} major=$major"
}

data class CliMessage(val role: String, val content: String)

interface Renderable {
    fun render(): String
}

class ConsoleMessage(private val message: CliMessage) : Renderable {
    override fun render(): String = "[${message.role}] ${message.content}"
}

object CliDefaults {
    const val DEFAULT_MODEL = "gpt-4o-mini"
}

fun demoClassesAndInterfaces() {
    val student = Student("小明", 18, "Computer Science")
    val renderable: Renderable = ConsoleMessage(CliMessage("user", "你好，AI"))

    println("[类/接口/静态] profile=${student.profile()} | ${renderable.render()} | model=${CliDefaults.DEFAULT_MODEL}")
}
