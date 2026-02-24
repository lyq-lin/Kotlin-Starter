package basics

fun <T> secondOrNull(items: List<T>): T? = if (items.size >= 2) items[1] else null

fun normalizeTags(input: List<String>): List<String> {
    return input
        .map { it.trim().lowercase() }
        .filter { it.isNotBlank() }
        .distinct()
        .sorted()
}

data class UserProfile(
    val id: Long,
    var nickname: String,
    var city: String,
)

fun displayName(profile: UserProfile?): String =
    profile?.let { "${it.nickname}@${it.city}" } ?: "anonymous"

fun updateNickname(profile: UserProfile, newName: String): UserProfile =
    profile.apply { nickname = newName }

fun demoLambdaGenericsAndScopes() {
    val tags = normalizeTags(listOf(" Kotlin ", "AI", "kotlin", " "))
    val second = secondOrNull(tags)
    val profile = UserProfile(1, "codex", "shanghai")

    println(
        "[lambda/generic/scope] tags=$tags, second=$second, display=${displayName(profile)}, updated=${updateNickname(profile, "gpt")}" 
    )
}
