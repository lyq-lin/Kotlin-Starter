package m05_controlflow

fun describeScore(score: Int): String = when {
    score >= 90 -> "A"
    score >= 80 -> "B"
    score >= 60 -> "C"
    else -> "D"
}

fun nullableNickname(name: String?): String {
    // Elvis 操作符 ?: —— 左侧为 null 时使用右侧默认值。
    return name ?: "游客"
}

fun main() {
    // if 是表达式：可以直接返回值。
    val age = 17
    val stage = if (age >= 18) "成人" else "未成年"
    println("age=$age -> $stage")

    // if/else if 链
    val temperature = 31
    val weatherTip = if (temperature >= 35) {
        "注意防暑"
    } else if (temperature >= 28) {
        "适合短袖"
    } else {
        "带件外套"
    }
    println("temperature=$temperature -> $weatherTip")

    // when 作为表达式
    val score = 86
    val level = describeScore(score)
    println("score=$score -> $level")

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

    // while 循环
    var countdown = 3
    while (countdown > 0) {
        print("$countdown ")
        countdown--
    }
    println("go!")

    val list = listOf(5, 456, 48, 156, 8465, 134, 864, 6, 4616, 153, 1, 6, 16, 51, 89, 631, 4)

    // 注意：遍历下标要用 until，避免访问到 count() 这个越界下标。
    for (index in 0 until list.count() step 2) {
        println("index=$index value=${list[index]}")
    }

    println("nullable nickname -> ${nullableNickname(null)}")
}
