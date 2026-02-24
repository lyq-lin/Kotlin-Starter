# Kotlin-starter（一个根项目 + 多模块）

你说得对：在 IDEA 里更常见、也更好管理的方式是 **一个根项目包含多个模块**。

本仓库现在已改成：根项目 `Kotlin-starter` 直接承载多个模块目录，并清理了旧的 `projects/*` 与 `modules/*` 中间层结构。

## 目录结构

```text
Kotlin-starter/
├── 01-BasicsRunner
├── 02-VariablesAndTypes
├── 03-Modifiers
├── 04-Functions
├── 05-ControlFlow
├── 06-ClassesAndDataClasses
├── 07-Collections
├── 08-NullSafety
├── 09-Extensions
├── 10-EnumsSealedResult
├── 11-LambdaGenericsScopes
├── 12-PracticalScenarios
├── 13-ImportantPatterns
├── 14-ai-cli
├── 15-web-api-demo
├── 16-kmp-demo
└── .idea/
```

## IDEA 使用方式

1. 用 IDEA 打开仓库根目录 `Kotlin-starter`。
2. 根目录下每个编号目录就是独立学习模块。
3. 每个模块都可单独运行：
   - `<module>/scripts/build.sh`
   - `<module>/scripts/run.sh`

## 环境

- JDK 17+
- kotlinc


## IDEA 运行报错排查（`MainKt` 找不到）

如果你看到：`Could not find or load main class MainKt`，通常是 **Run Configuration 没有绑定到模块 classpath** 或 **没有编译输出目录**。

请按下面检查：

1. **重新导入项目**
   - 在 IDEA 中关闭项目后，重新从仓库根目录 `Kotlin-starter` 打开。
   - 确认 Project 视图下能看到 `.idea/modules.xml` 里的全部模块。

2. **检查 SDK**
   - `File -> Project Structure -> Project`
   - `Project SDK` 设为你的本地 JDK（你当前是 JDK 25，则选 25）。

3. **检查 Run Configuration**
   - `Run -> Edit Configurations...`
   - `Main class` 设为 `MainKt`（当前示例为顶层 `main` 函数）。
   - **Use classpath of module** 必须选择你正在运行的模块（例如 `01-BasicsRunner`）。

4. **先 Build 再 Run**
   - 先执行 `Build -> Build Project`。
   - 再运行 `MainKt`。

仓库已提供 `.idea/misc.xml` 与 `.idea/compiler.xml`，默认把编译输出放到根目录 `out/`，并将项目 SDK 对齐到 IDEA 配置中的 JDK（当前仓库默认 25，可按你本地环境调整）。
