package m05_controlflow

// 本模块主题：控制流（if / when / for / while / Elvis ?:）

fun describeScore(score: Int): String = when {
    score >= 90 -> "A"
    score >= 80 -> "B"
    score >= 60 -> "C"
    else -> "D"
}

fun nullableNickname(name: String?): String = name ?: "游客"

fun main() {
    val age = 17
    val stage = if (age >= 18) "成人" else "未成年"
    println("age=$age -> $stage")

    val temperature = 31
    val weatherTip = if (temperature >= 35) {
        "注意防暑"
    } else if (temperature >= 28) {
        "适合短袖"
    } else {
        "带件外套"
    }
    println("temperature=$temperature -> $weatherTip")

    val score = 86
    println("score=$score -> ${describeScore(score)}")

    for (i in 1..7 step 2) {
        if (i == 5) continue
        print("$i ")
    }
    println()

    for (i in 3 downTo 1) print("$i ")
    println()

    var countdown = 3
    while (countdown > 0) {
        print("$countdown ")
        countdown--
    }
    println("go!")

    val list = listOf(5, 456, 48, 156, 8465, 134, 864, 6)
    for (index in 0 until list.count() step 2) {
        println("index=$index value=${list[index]}")
    }

    println("nullable nickname -> ${nullableNickname(null)}")
}
