package m06_classesanddataclasses

interface Renderable { fun render(): String }

// data class 自动获得 equals/hashCode/toString/copy/componentN
// 适合承载数据。
data class User(val id: Long, val name: String)

class WelcomeCard(private val user: User) : Renderable {
    override fun render(): String = "Welcome ${user.name} (#${user.id})"

    companion object {
        const val DEFAULT_THEME = "light"
    }
}

fun main() {
    val user = User(1, "Alice")

    // copy: 基于旧对象生成新对象。
    val vipUser = user.copy(name = "Alice VIP")

    // 解构声明
    val (id, name) = vipUser

    val msg = WelcomeCard(vipUser)
    println(msg.render())
    println("theme=" + WelcomeCard.DEFAULT_THEME)
    println("destructured: id=$id name=$name")
}
