package cli

interface AiClient {
    fun ask(prompt: String): String
}

class MockAiClient : AiClient {
    override fun ask(prompt: String): String = "[mock-koog] 你问的是：$prompt"
}
