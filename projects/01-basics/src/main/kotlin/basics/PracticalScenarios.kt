package basics

/**
 * 场景：电商订单金额计算
 * - 演示 data class + 集合 + 条件分支
 * - 日常开发常见：活动价、满减、最终应付金额
 */
data class OrderItem(
    val name: String,
    val price: Double,
    val quantity: Int,
)

data class OrderSummary(
    val subtotal: Double,
    val discount: Double,
    val finalAmount: Double,
)

fun calculateOrder(items: List<OrderItem>, coupon: String?): OrderSummary {
    val subtotal = items.sumOf { it.price * it.quantity }

    // 简化规则：
    // VIP95 => 95 折
    // SAVE20 => 满 100 减 20
    // 其他 => 无优惠
    val discount = when (coupon) {
        "VIP95" -> subtotal * 0.05
        "SAVE20" -> if (subtotal >= 100) 20.0 else 0.0
        else -> 0.0
    }

    val finalAmount = (subtotal - discount).coerceAtLeast(0.0)
    return OrderSummary(subtotal, discount, finalAmount)
}

/**
 * 场景：接口返回值解析
 * - 结合 sealed class，模拟“成功/失败”返回
 * - 避免直接抛异常，调用侧可以强类型处理
 */
fun fetchUserNameById(id: Long): ApiResult<String> {
    if (id <= 0) return ApiResult.Failure("invalid id")
    if (id == 404L) return ApiResult.Failure("user not found")
    return ApiResult.Success("user-$id")
}

fun demoPracticalScenarios() {
    val items = listOf(
        OrderItem("Keyboard", 299.0, 1),
        OrderItem("Mouse", 99.0, 1),
    )
    val summary = calculateOrder(items, "SAVE20")

    val userResult = fetchUserNameById(1)

    println("[实战场景] order=$summary, userResult=$userResult")
}
