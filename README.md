# Kotlin-starter（一个根项目 + 多模块）

你说得对：在 IDEA 里更常见、也更好管理的方式是 **一个根项目包含多个模块**。

本仓库现在已改成：根项目 `Kotlin-starter` + `modules/*` 多模块结构，并清理了旧的 `projects/*` 结构。

## 目录结构

```text
Kotlin-starter/
├── modules/
│   ├── 01-BasicsRunner
│   ├── 02-VariablesAndTypes
│   ├── 03-Modifiers
│   ├── 04-Functions
│   ├── 05-ControlFlow
│   ├── 06-ClassesAndDataClasses
│   ├── 07-Collections
│   ├── 08-NullSafety
│   ├── 09-Extensions
│   ├── 10-EnumsSealedResult
│   ├── 11-LambdaGenericsScopes
│   ├── 12-PracticalScenarios
│   ├── 13-ImportantPatterns
│   ├── 14-ai-cli
│   ├── 15-web-api-demo
│   └── 16-kmp-demo
├── scripts/
└── .idea/
```

## IDEA 使用方式

1. 用 IDEA 打开仓库根目录 `Kotlin-starter`。
2. 你会看到这是一个根工程，`modules/` 下每个目录是独立学习模块。
3. 每个模块都可单独运行：
   - `modules/<module>/scripts/build.sh`
   - `modules/<module>/scripts/run.sh`

## 根目录快捷命令

```bash
# 构建所有可构建模块
./scripts/build-jar.sh

# 跑学习导航
./scripts/run-basics.sh

# 跑 AI CLI
./scripts/run-ai.sh
```

## 环境

- JDK 17+
- kotlinc
