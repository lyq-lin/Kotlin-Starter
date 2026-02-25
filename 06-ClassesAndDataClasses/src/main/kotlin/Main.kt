package m06_classesanddataclasses

// 本模块主题：类与数据类（final/open、data class、object、sealed）

interface Renderable { fun render(): String }

data class User(val id: Long, val name: String)

// 默认 final（不可继承）
class FinalAccount(val owner: String)

open class Account(open val owner: String) {
    open fun role(): String = "member"
}

class VipAccount(override val owner: String) : Account(owner) {
    override fun role(): String = "vip"
}

// sealed：限制子类集合；不能直接实例化 sealed 父类
sealed class PaymentState {
    data object Idle : PaymentState()
    data class Paid(val amount: Int) : PaymentState()
    data class Failed(val reason: String) : PaymentState()
}

// object：单例对象
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
    println("final account owner=${FinalAccount("Tom").owner}")

    val userMsg = WelcomeCard(user)
    val cardFromFactory = WelcomeCard.from("Carol")
    println(userMsg.render())
    println(cardFromFactory.render())
    println("theme=${WelcomeCard.DEFAULT_THEME}")
    println("destructured: id=$id name=$name")

    println(renderState(PaymentState.Idle))
    println(renderState(PaymentState.Paid(88)))
    println(renderState(PaymentState.Failed("network")))
}
