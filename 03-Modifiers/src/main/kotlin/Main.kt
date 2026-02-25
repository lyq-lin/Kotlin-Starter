package m03_modifiers

// 本模块主题：可见性与继承修饰符（public/internal/protected/private、open/override）

open class Animal(protected val name: String) {
    open fun speak(): String = "$name makes a sound"
}

class Dog(name: String) : Animal(name) {
    override fun speak(): String = "$name says woof"
}

// internal：同一模块可见
internal class AnimalReporter {
    fun report(animal: Animal): String = "[internal] ${animal.speak()}"
}

// private：仅当前文件可见
private fun internalNote() = "private helper"

fun main() {
    val dog = Dog("Coco")
    println(dog.speak())
    println(AnimalReporter().report(dog))
    println(internalNote())
}
