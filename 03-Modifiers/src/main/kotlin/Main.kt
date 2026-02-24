package m03_modifiers

open class Animal(protected val name: String) {
    open fun speak(): String = "$name makes a sound"
}

class Dog(name: String) : Animal(name) {
    override fun speak(): String = "$name says woof"
}

private fun internalNote() = "private helper"

fun main() {
    println(Dog("Coco").speak())
    println(internalNote())
}
