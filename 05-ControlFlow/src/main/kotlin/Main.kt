package m05_controlflow

fun describeScore(score: Int): String = when {
    score >= 90 -> "A"
    score >= 80 -> "B"
    score >= 60 -> "C"
    else -> "D"
}

fun main() {
    for (i in 1..5) {
        if (i == 3) continue
        print("$i ")
    }
    println()
    println("score=86 -> ${describeScore(86)}")
}
