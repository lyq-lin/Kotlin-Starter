package m03_modifiers

// open: Kotlin 类默认 final，不可继承；加 open 后才允许被继承。
open class Animal(protected val name: String) {
    // protected: 仅当前类及子类可访问。
    open fun speak(): String = "$name makes a sound"
}

class Dog(name: String) : Animal(name) {
    // override: 重写父类成员。
    override fun speak(): String = "$name says woof"
}

// internal: 同一个模块可见（跨模块不可见）。
internal class AnimalReporter {
    fun report(animal: Animal): String = "[internal] ${animal.speak()}"
}

// private: 仅当前文件可见。
private fun internalNote() = "private helper"

fun main() {
    val dog = Dog("Coco")
    println(dog.speak())
    println(AnimalReporter().report(dog))
    println(internalNote())
}
