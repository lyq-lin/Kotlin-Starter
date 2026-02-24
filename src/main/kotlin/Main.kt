import basics.runAllBasics
import cli.AiCliApp

fun main(args: Array<String>) {
    val mode = args.firstOrNull()?.lowercase() ?: "help"
    when (mode) {
        "basics" -> runAllBasics()
        "ai" -> AiCliApp().run()
        else -> printHelp()
    }
}

private fun printHelp() {
    println(
        """
        Kotlin 从 0 到 1 Demo（原生 JVM 编译）
        用法:
          java -jar out/kotlin-starter.jar basics   # 运行 Kotlin 基础语法演示
          java -jar out/kotlin-starter.jar ai       # 运行 Koog 风格 AI CLI
        构建:
          ./scripts/build-jar.sh
        """.trimIndent()
    )
}
