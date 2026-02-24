package basics

private const val INTERNAL_DOC_VERSION = "v1"

open class Animal(protected val nickname: String) {
    open fun speak(): String = "$nickname: ..."
}

class Cat(nickname: String) : Animal(nickname) {
    override fun speak(): String = "$nickname: meow"
}

fun demoModifiersAndVisibility() {
    val cat = Cat("Kitty")
    println("[修饰符] ${cat.speak()} | doc=$INTERNAL_DOC_VERSION")
}
