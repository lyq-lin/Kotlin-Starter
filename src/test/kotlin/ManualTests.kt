import basics.Cat
import basics.CliDefaults
import basics.evenNumbersInRange
import basics.grade
import basics.lastCharOrQuestionMark
import basics.sum
import basics.toSlug

private fun assertEquals(expected: Any, actual: Any, name: String) {
    if (expected != actual) {
        error("[$name] expected=$expected actual=$actual")
    }
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

    println("All manual tests passed.")
}
