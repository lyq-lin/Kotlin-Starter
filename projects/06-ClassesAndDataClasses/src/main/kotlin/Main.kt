interface Renderable { fun render(): String }

data class User(val id: Long, val name: String)

class WelcomeCard(private val user: User) : Renderable {
    override fun render(): String = "Welcome ${user.name} (#${user.id})"

    companion object {
        const val DEFAULT_THEME = "light"
    }
}

fun main() {
    val msg = WelcomeCard(User(1, "Alice"))
    println(msg.render())
    println("theme=" + WelcomeCard.DEFAULT_THEME)
}
