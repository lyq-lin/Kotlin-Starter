package m14_aicli

import cli.AiCliApp

fun main() {
    // 入口函数保持极简：
    // - 负责启动应用
    // - 复杂逻辑留在 cli 包，便于测试与复用
    val app = AiCliApp()
    app.run()
}
