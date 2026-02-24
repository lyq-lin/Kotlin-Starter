package basics

fun grade(score: Int): String = when {
    score >= 90 -> "A"
    score >= 80 -> "B"
    score >= 70 -> "C"
    else -> "D"
}

fun evenNumbersInRange(start: Int, end: Int): List<Int> {
    val result = mutableListOf<Int>()
    for (i in start..end) {
        if (i % 2 != 0) continue
        result += i
    }
    return result
}

fun demoControlFlow() {
    val score = 88
    val even = evenNumbersInRange(1, 10)
    println("[分支/循环] score=$score => level=${grade(score)}, even=$even")
}
