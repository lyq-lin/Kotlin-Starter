# Kotlin 完全入门（0 到 1）+ Koog AI CLI Demo（无 Gradle 版）

你问“还有什么很重要、很想分享的点”，我最想补这 3 个：

1. **`Result` + `runCatching`**：让错误处理更工程化，而不是到处 try/catch
2. **`Sequence` 惰性流**：处理大数据流时更省中间对象
3. **接口委托 + `lazy`**：减少模板代码，延迟初始化配置/令牌

这些都已经在代码里补好了，并写了中文注释。

---

## 1. 环境要求

- JDK 17+
- Kotlin 编译器 `kotlinc`

```bash
java -version
kotlinc -version
```

---

## 2. 一键运行

```bash
./scripts/build-jar.sh
./scripts/run-basics.sh
```

AI CLI：

```bash
export KOOG_API_KEY="your_api_key"
export KOOG_MODEL="gpt-4o-mini"
export KOOG_BASE_URL="https://api.openai.com/v1"
./scripts/run-ai.sh
```

---

## 3. 新增“重要分享”案例

### 3.1 Result + runCatching
- 文件：`src/main/kotlin/basics/ImportantPatterns.kt`
- 函数：`safeDivide(a, b)`
- 用法：`safeDivide(...).getOrNull()` / `.isFailure`

### 3.2 Sequence 惰性流
- 文件：`src/main/kotlin/basics/ImportantPatterns.kt`
- 函数：`firstLargeEven(numbers)`
- 场景：大列表链式处理，减少中间集合开销

### 3.3 接口委托 + lazy
- 文件：`src/main/kotlin/basics/ImportantPatterns.kt`
- 类型：`NotificationService(private val delegate: Sender) : Sender by delegate`
- 场景：委托发送能力，token 延迟加载且仅初始化一次

---

## 4. 当前覆盖（核心）

- 基础语法、分支循环、类与接口、集合、空安全、扩展函数
- enum + sealed 结果建模
- 泛型 + lambda + scope function
- 业务场景：订单计算、接口返回、日志聚合、配置兜底
- 重要模式：Result、Sequence、委托、lazy

入口：`src/main/kotlin/basics/BasicsRunner.kt`

---

## 5. 测试（无 Gradle）

```bash
./scripts/test.sh
```

测试入口：`src/test/kotlin/ManualTests.kt`。
