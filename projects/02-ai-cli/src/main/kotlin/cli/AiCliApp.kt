package cli

class AiCliApp {
    fun run() {
        val config = try {
            Config.loadFromEnv()
        } catch (e: IllegalStateException) {
            println("配置错误: ${e.message}")
            println("请参考 README 的环境变量配置后重试。")
            return
        }

        val client: AiClient = MockKoogStyleClient(config)

        println("=== Koog 风格 AI CLI ===")
        println("已加载模型: ${config.model}")
        println("输入你的问题，输入 exit 退出。")

        while (true) {
            print("> ")
            val input = readlnOrNull()?.trim().orEmpty()
            if (input.equals("exit", ignoreCase = true)) break
            if (input.isBlank()) continue

            try {
                val answer = client.ask(input)
                println(answer)
            } catch (e: Exception) {
                println("请求失败: ${e.message}")
            }
        }

        println("已退出 AI CLI。")
    }
}
