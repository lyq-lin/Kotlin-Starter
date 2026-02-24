# Kotlin 从 0 到 1（原子化多项目）

你提的方向完全正确：**按知识点拆成多个独立项目**，会比“一个项目塞全部类”更清晰。

## 项目目录（推荐学习顺序）

```text
projects/
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
└── 16-kmp-demo
```

每个编号项目都可单独 `build/run`，互不依赖，便于你按主题逐个学习。

## 运行方式（纯 Kotlin + JVM）

前置：JDK 17+ 与 `kotlinc`。

```bash
# 运行学习导航
./projects/01-BasicsRunner/scripts/run.sh

# 按主题运行
./projects/06-ClassesAndDataClasses/scripts/run.sh
./projects/10-EnumsSealedResult/scripts/run.sh

# 运行 AI CLI
./projects/14-ai-cli/scripts/run.sh

# 运行 Web API demo
./projects/15-web-api-demo/scripts/run.sh
# 打开 http://localhost:8080/health
```

## 关于 KMP

`16-kmp-demo` 先提供结构和迁移建议（README），用于指导你下一步从 JVM 示例迁移到多平台项目。
