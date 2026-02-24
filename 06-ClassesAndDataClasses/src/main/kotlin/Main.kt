package m06_classesanddataclasses

interface Renderable { fun render(): String }

// data class 自动获得 equals/hashCode/toString/copy/componentN
// 适合承载数据。
data class User(val id: Long, val name: String)

class WelcomeCard(private val user: User) : Renderable {
    override fun render(): String = "Welcome ${user.name} (#${user.id})"

    // companion object：类级别“伴生对象”。
    // 你可以把它理解成“这个类自带的单例工具区”，常用于放：
    // 1) 常量（如主题、默认值）
    // 2) 工厂方法（如 fromXxx(...)）
    // 3) 与实例无关、但语义上属于这个类的工具函数
    //
    // 为什么 Kotlin 不直接用 Java 的 static？
    // - Kotlin 倾向“一切皆对象”，companion 本身就是对象，能实现接口、可被传参。
    // - 这样比 static 更统一：既可像静态成员一样用 `WelcomeCard.DEFAULT_THEME` 调用，
    //   又保留对象能力。
    companion object {
        const val DEFAULT_THEME = "light"

        fun from(id: Long, name: String): WelcomeCard = WelcomeCard(User(id, name))
    }
}

fun main() {
    val user = User(1, "Alice")

    // copy: 基于旧对象生成新对象。
    val vipUser = user.copy(name = "Alice VIP")

    // 解构声明
    val (id, name) = vipUser

    val msg = WelcomeCard(vipUser)
    val cardFromFactory = WelcomeCard.from(2, "Bob")
    println(msg.render())
    println(cardFromFactory.render())
    println("theme=" + WelcomeCard.DEFAULT_THEME)
    println("destructured: id=$id name=$name")
}
