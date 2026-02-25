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
| 01-BasicsRunner | 学习导航：按知识点定位模块 |
| 02-VariablesAndTypes | 变量、类型与属性基础 |
| 03-Modifiers | 可见性与继承修饰符 |
| 04-Functions | 函数、默认参数、`vararg`、`infix` |
| 05-ControlFlow | `if` / `when` / `for` / `while` / Elvis `?:` |
| 06-ClassesAndDataClasses | 类基础、`open`、`object`、`sealed`、`data class` |
| 07-Collections | `List` / `Map` 与常用集合 API |
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

### 学习设计说明（0x 模块）

- 01-13 模块优先按“**单一知识点可定位**”组织，避免把无关内容堆在一个示例里。
- 每个模块的 `Main.kt` 都可单独运行，建议按“先看注释目标 -> 再运行输出 -> 最后改参数实验”的方式学习。
- 若要复习某个语法，请优先通过模块名定位：
  - 控制流：`05-ControlFlow`
  - 类层次（`open`/`sealed`/`object`）：`06-ClassesAndDataClasses`、`10-EnumsSealedResult`
  - 集合：`07-Collections`
  - 空安全与默认值：`08-NullSafety`

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

## 贡献建议

欢迎通过 Issue / PR 提交：
- 示例可读性改进（注释、命名、结构）
- 新的 Kotlin 实战主题
- 错误修复与文档完善

