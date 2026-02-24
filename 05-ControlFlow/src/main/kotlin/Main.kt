package m05_controlflow

fun describeScore(score: Int): String = when {
    score >= 90 -> "A"
    score >= 80 -> "B"
    score >= 60 -> "C"
    else -> "D"
}

fun main() {
    // 区间 + 步长 + continue
    for (i in 1..7 step 2) {
        if (i == 5) continue
        print("$i ")
    }
    println()

    // downTo 倒序循环
    for (i in 3 downTo 1) {
        print("$i ")
    }
    println()

    val list = listOf(5,456,48,156,8465,134,864,6,4616,153,1,6,16,51,89,631,4)

    // 注意：遍历下标要用 until，避免访问到 count() 这个越界下标。
    for (index in 0 until list.count() step 2) {
        println(list[index])
    }

    // when 作为表达式
    val score = 86
    val level = describeScore(score)
    println("score=$score -> $level")
}
