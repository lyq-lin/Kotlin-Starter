package cli

class AiCliApp {
    private val client: AiClient = MockAiClient()

    fun run() {
        println("AI CLI 启动，输入 exit 退出")
        while (true) {
            print("> ")
            val input = readlnOrNull()?.trim().orEmpty()
            if (input == "exit") return
            if (input.isBlank()) continue
            println(client.ask(input))
        }
    }
}
