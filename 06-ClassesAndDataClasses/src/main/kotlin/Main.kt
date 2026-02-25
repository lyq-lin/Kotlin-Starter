package m06_classesanddataclasses

interface Renderable { fun render(): String }

// data class 自动获得 equals/hashCode/toString/copy/componentN
// 适合承载数据。
data class User(val id: Long, val name: String)

// Kotlin 中 class 默认是 final（不可继承）。
class FinalAccount(val owner: String)

// 想被继承，必须显式加 open。
open class Account(open val owner: String) {
    open fun role(): String = "member"
}

class VipAccount(override val owner: String) : Account(owner) {
    override fun role(): String = "vip"
}

// sealed class：限制子类范围，只允许在同文件内声明子类。
// 它通常用于“有限状态建模”。
// 注意 sealed 类不能被直接实例化：因为它本质上是一个受限层级的抽象父类型。
sealed class PaymentState {
    data object Idle : PaymentState()
    data class Paid(val amount: Int) : PaymentState()
    data class Failed(val reason: String) : PaymentState()
}

// object：声明一个单例对象。
// 常见用途：工具类、配置、无状态服务。
object IdGenerator {
    private var nextId = 1000L
    fun next(): Long = nextId++
}

class WelcomeCard(private val user: User) : Renderable {
    override fun render(): String = "Welcome ${user.name} (#${user.id})"

    companion object {
        const val DEFAULT_THEME = "light"
        fun from(name: String): WelcomeCard = WelcomeCard(User(IdGenerator.next(), name))
    }
}

fun renderState(state: PaymentState): String = when (state) {
    PaymentState.Idle -> "waiting"
    is PaymentState.Paid -> "paid=${state.amount}"
    is PaymentState.Failed -> "failed=${state.reason}"
}

fun main() {
    val user = User(1, "Alice")
    val vipUser = user.copy(name = "Alice VIP")
    val (id, name) = vipUser

    val account: Account = VipAccount("Bob")
    println("owner=${account.owner}, role=${account.role()}")

    // FinalAccount 默认不可继承，这里只演示可实例化。
    println("final account owner=${FinalAccount("Tom").owner}")

    val userMsg = WelcomeCard(user)
    val cardFromFactory = WelcomeCard.from("Carol")
    println(userMsg.render())
    println(cardFromFactory.render())
    println("theme=" + WelcomeCard.DEFAULT_THEME)
    println("destructured: id=$id name=$name")

    println(renderState(PaymentState.Idle))
    println(renderState(PaymentState.Paid(88)))
    println(renderState(PaymentState.Failed("network")))
}
