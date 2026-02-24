import basics.ApiResult
import basics.Cat
import basics.CliDefaults
import basics.Environment
import basics.OrderItem
import basics.calculateOrder
import basics.displayName
import basics.endpointFor
import basics.evenNumbersInRange
import basics.fetchUserNameById
import basics.grade
import basics.lastCharOrQuestionMark
import basics.normalizeTags
import basics.parsePort
import basics.parseTimeoutMs
import basics.secondOrNull
import basics.sum
import basics.toSlug
import basics.topLogLevels
import basics.updateNickname
import basics.UserProfile

private fun assertEquals(expected: Any?, actual: Any?, name: String) {
    if (expected != actual) {
        error("[$name] expected=$expected actual=$actual")
    }
}

private fun assertTrue(condition: Boolean, name: String) {
    if (!condition) error("[$name] condition is false")
}

fun main() {
    assertEquals('n', "Kotlin".lastCharOrQuestionMark(), "lastChar")
    assertEquals('?', "".lastCharOrQuestionMark(), "emptyLastChar")
    assertEquals(15, sum(5), "defaultArg")
    assertEquals("kotlin-cli", "Kotlin CLI".toSlug(), "toSlug")
    assertEquals("B", grade(88), "grade")
    assertEquals(listOf(2, 4, 6), evenNumbersInRange(1, 6), "evenRange")
    assertEquals("Kitty: meow", Cat("Kitty").speak(), "modifierOverride")
    assertEquals("gpt-4o-mini", CliDefaults.DEFAULT_MODEL, "objectConst")

    assertEquals("https://api.service.com", endpointFor(Environment.PROD), "enumWhen")
    assertTrue(parsePort("8080") is ApiResult.Success, "sealedSuccess")
    assertTrue(parsePort("x") is ApiResult.Failure, "sealedFailure")

    assertEquals("ai", secondOrNull(listOf("kotlin", "ai", "cli")), "genericSecond")
    assertEquals(listOf("ai", "kotlin"), normalizeTags(listOf(" Kotlin ", "AI", "kotlin", " ")), "lambdaPipeline")

    val profile = UserProfile(1, "codex", "shanghai")
    assertEquals("codex@shanghai", displayName(profile), "letDisplay")
    assertEquals("gpt", updateNickname(profile, "gpt").nickname, "applyUpdate")
    assertEquals("anonymous", displayName(null), "nullDisplay")

    assertEquals(5000, parseTimeoutMs("5000"), "timeoutParse")
    assertEquals(3000, parseTimeoutMs("bad"), "timeoutFallback")

    val topLevels = topLogLevels(listOf("INFO:a", "WARN:b", "INFO:c"))
    assertEquals("INFO", topLevels.first().first, "topLogLevel")

    val order = calculateOrder(listOf(OrderItem("A", 60.0, 2)), "SAVE20")
    assertEquals(120.0, order.subtotal, "orderSubtotal")
    assertEquals(20.0, order.discount, "orderDiscount")

    assertTrue(fetchUserNameById(1) is ApiResult.Success, "fetchUserSuccess")
    assertTrue(fetchUserNameById(404) is ApiResult.Failure, "fetchUserNotFound")

    println("All manual tests passed.")
}
