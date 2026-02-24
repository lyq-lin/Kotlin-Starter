package basics

fun demoCollections() {
    val langs = listOf("Kotlin", "Java", "Python")
    val upper = langs.map { it.uppercase() }

    val scores = mutableMapOf("Alice" to 90, "Bob" to 85)
    scores["Cindy"] = 95

    println("[集合] upper=$upper, scores=$scores")
}
