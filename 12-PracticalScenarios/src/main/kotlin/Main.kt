package m12_practicalscenarios

data class Order(val originalPrice: Double, val discountRate: Double)

fun finalPrice(order: Order): Double {
    // 场景：电商价格计算（先折扣后满减）
    val discounted = order.originalPrice * (1 - order.discountRate)
    return if (discounted >= 200) discounted - 20 else discounted
}

fun main() {
    println(finalPrice(Order(260.0, 0.1)))
}
