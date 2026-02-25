package m12_practicalscenarios

import java.math.BigDecimal

// 本模块主题：业务小场景（价格计算）

data class Order(val originalPrice: BigDecimal, val discountRate: BigDecimal)

fun finalPrice(order: Order): BigDecimal {
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
