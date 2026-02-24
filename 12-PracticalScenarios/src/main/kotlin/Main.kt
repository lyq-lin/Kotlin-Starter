package m12_practicalscenarios

import java.math.BigDecimal

data class Order(val originalPrice: BigDecimal, val discountRate: BigDecimal)

fun finalPrice(order: Order): BigDecimal {
    // 场景：电商价格计算（先折扣后满减）
    val discounted = order.originalPrice.multiply(BigDecimal.ONE.subtract(order.discountRate))
    return if (discounted >= BigDecimal("200")) discounted.subtract(BigDecimal("20")) else discounted
}

fun main() {
    val order = Order(
        originalPrice = BigDecimal("260.00"),
        discountRate = BigDecimal("0.10")
    )
    println(finalPrice(order))
}
