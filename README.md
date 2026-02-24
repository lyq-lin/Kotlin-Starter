# Kotlin 完全入门（0 到 1）+ Koog AI CLI Demo（无 Gradle 版）

你提到不需要 Gradle，这个版本改成 **纯 Kotlin/JVM 原生编译**：

- 使用 `kotlinc` 编译
- 使用 `java -jar` 运行
- 使用脚本执行基础测试

---

## 1. 环境要求

- JDK 17+
- Kotlin 编译器 `kotlinc`

可检查：

```bash
java -version
kotlinc -version
```

---

## 2. 一键运行

### 2.1 构建可执行 Jar

```bash
./scripts/build-jar.sh
```

产物：`out/kotlin-starter.jar`

### 2.2 运行语法入门 demo

```bash
./scripts/run-basics.sh
```

### 2.3 运行 Koog 风格 AI CLI

```bash
export KOOG_API_KEY="your_api_key"
export KOOG_MODEL="gpt-4o-mini"
export KOOG_BASE_URL="https://api.openai.com/v1"
./scripts/run-ai.sh
```

输入 `exit` 退出。

---

## 3. 从 0 到 1 学习路线（按文件）

1. `src/main/kotlin/basics/VariablesAndTypes.kt`：变量与类型
2. `src/main/kotlin/basics/ModifiersAndVisibility.kt`：修饰符与可见性
3. `src/main/kotlin/basics/Functions.kt`：函数、默认参数、扩展函数
4. `src/main/kotlin/basics/ControlFlow.kt`：分支与循环
5. `src/main/kotlin/basics/ClassesAndDataClasses.kt`：类/数据类/接口/object(静态风格)
6. `src/main/kotlin/basics/Collections.kt`：集合
7. `src/main/kotlin/basics/NullSafety.kt`：空安全
8. `src/main/kotlin/basics/Extensions.kt`：扩展函数

入口：`src/main/kotlin/basics/BasicsRunner.kt`

---

## 4. AI CLI 与语法知识映射

- `src/main/kotlin/cli/Config.kt`：环境变量读取与默认值
- `src/main/kotlin/cli/AiClient.kt`：接口抽象（可替换真实 Koog SDK）
- `src/main/kotlin/cli/AiCliApp.kt`：循环输入、异常处理

---

## 5. 无 Gradle 测试方式

```bash
./scripts/test.sh
```

测试入口：`src/test/kotlin/ManualTests.kt`

当前覆盖：
- 扩展函数
- 默认参数
- 分支/循环
- 修饰符/override
- object 静态常量

---

## 6. 后续接入真实 Koog SDK

当前 `MockKoogStyleClient` 是教学占位实现。接入真实 SDK 的步骤：

1. 增加 SDK 依赖（如你自己的编译链：手工 classpath 或 Maven/Gradle 均可）
2. 新建 `KoogSdkClient : AiClient`
3. 在 `AiCliApp` 中替换默认 client
