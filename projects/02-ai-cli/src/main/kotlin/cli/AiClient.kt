package cli

/**
 * 为了保证此 demo 在空仓库可直接编译运行，这里定义了一个最小 AI 客户端接口。
 * 如果你已接入 Koog SDK，可新增 KoogSdkClient 实现并替换 AiCliApp 中的 client。
 */
interface AiClient {
    fun ask(question: String): String
}

class MockKoogStyleClient(private val config: AiConfig) : AiClient {
    override fun ask(question: String): String {
        return "[Mock ${config.model}] 你问的是: \"$question\"。\n" +
            "这里是 Koog 风格 CLI 的占位回复。你可以把它替换成真实 Koog SDK 调用。"
    }
}
