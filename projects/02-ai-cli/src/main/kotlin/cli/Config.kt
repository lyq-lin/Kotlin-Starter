package cli

data class AiConfig(
    val apiKey: String,
    val model: String,
    val baseUrl: String,
)

object Config {
    fun loadFromEnv(): AiConfig {
        val apiKey = System.getenv("KOOG_API_KEY")
            ?: error("缺少 KOOG_API_KEY，请先配置环境变量")

        val model = System.getenv("KOOG_MODEL") ?: "gpt-4o-mini"
        val baseUrl = System.getenv("KOOG_BASE_URL") ?: "https://api.openai.com/v1"

        return AiConfig(apiKey = apiKey, model = model, baseUrl = baseUrl)
    }
}
