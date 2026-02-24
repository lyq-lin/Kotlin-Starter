# Kotlin Starter

一个面向初学者与进阶开发者的 **Kotlin 学习型多模块项目**。  
目标是通过循序渐进的小案例，快速建立 Kotlin 核心语法、常见工程写法和实际场景思维。

---

## 项目定位

- **学习路径清晰**：按编号从 `01` 到 `16` 逐步深入。
- **每个模块可独立运行**：便于按主题单点练习。
- **IDEA 友好**：默认按 IntelliJ IDEA 工作流设计，不依赖脚本。

适合人群：
- 想系统入门 Kotlin 的同学
- Java 开发者迁移 Kotlin
- 想用小而全的样例快速复习 Kotlin 语法

---

## 模块总览

| 模块 | 主题 |
|---|---|
| 01-BasicsRunner | 学习导航与模块入口 |
| 02-VariablesAndTypes | 变量、类型与属性基础 |
| 03-Modifiers | 可见性与继承修饰符 |
| 04-Functions | 函数、默认参数、`vararg`、`infix` |
| 05-ControlFlow | 条件、循环与 `when` |
| 06-ClassesAndDataClasses | 类、接口、`data class` |
| 07-Collections | 集合处理与聚合 |
| 08-NullSafety | 空安全与可空类型 |
| 09-Extensions | 扩展函数 |
| 10-EnumsSealedResult | 枚举、密封类与结果建模 |
| 11-LambdaGenericsScopes | Lambda、泛型、作用域函数 |
| 12-PracticalScenarios | 业务场景示例 |
| 13-ImportantPatterns | 常见模式（`lazy`、`Result` 等） |
| 14-ai-cli | CLI 示例 |
| 15-web-api-demo | 轻量 Web API 示例 |
| 16-kmp-demo | Kotlin Multiplatform 示例 |

---

## 快速开始（IntelliJ IDEA）

1. 使用 IDEA 打开仓库根目录 `Kotlin-Starter`。
2. 等待索引与模块加载完成。
3. 在右上角选择模块对应的 Run Configuration（仓库已提供 `.idea/runConfigurations/*.xml`）。
4. 运行后可在控制台看到该模块的示例输出。

> 也可以直接运行各模块下的 `src/main/kotlin/Main.kt` 入口。

---

## 环境要求

- JDK 17+
- IntelliJ IDEA（推荐最新稳定版）

> 命令行编译需要 `kotlinc`，但本仓库默认推荐 IDEA 工作流。

---

## 项目结构

```text
Kotlin-Starter/
├── 01-BasicsRunner
├── 02-VariablesAndTypes
├── 03-Modifiers
├── ...
├── 16-kmp-demo
├── docs/
└── .idea/
```

---

## 常见问题

### 1) 运行时报 `Could not find or load main class MainKt`

通常是 Run Configuration 没绑定到正确模块：

- 打开 `Run -> Edit Configurations...`
- 确认 `Main class` 为对应包名下的 `MainKt`（如 `m01_basicsrunner.MainKt`）
- 确认 `Use classpath of module` 指向当前模块
- 执行一次 `Build -> Build Project` 后再运行

### 2) 为什么没有 `scripts/build.sh` / `scripts/run.sh`

本仓库已统一为 **IDEA 优先** 工作流，避免维护重复的脚本入口。

---

## 贡献建议

欢迎通过 Issue / PR 提交：
- 示例可读性改进（注释、命名、结构）
- 新的 Kotlin 实战主题
- 错误修复与文档完善

