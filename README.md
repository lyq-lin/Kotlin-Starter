# Kotlin 完全入门（0 到 1）+ Koog AI CLI Demo（无 Gradle 版）

你提到希望“持续补充案例，并带注释解释场景/用法”，本版本重点做了这件事：

- 每个知识点尽量提供**业务化场景说明**（不是只讲语法）
- 示例函数命名尽量可读（看名字就知道要解决什么）
- 手工测试增加“用例式断言”，可当作学习 checklist

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

### 2.1 构建可执行 Jar

```bash
./scripts/build-jar.sh
```

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

---

## 3. 已覆盖知识点 + 对应“场景”

1. 变量与类型：基础数据组织
2. 修饰符/可见性：API 暴露边界控制
3. 函数与扩展函数：复用逻辑，减少重复代码
4. 分支与循环：规则判断、批处理
5. 类/继承/接口/object：建模与抽象
6. 集合处理：日志/数据聚合分析（`groupBy` / `mapValues`）
7. 空安全：配置读取与兜底
8. enum + sealed：环境分流、成功失败建模
9. 泛型 + lambda + scope function：通用工具、链式数据处理、对象就地更新
10. 实战场景案例：订单金额计算、用户接口结果处理

入口：`src/main/kotlin/basics/BasicsRunner.kt`

---

## 4. 重点新增案例（建议先看）

- `PracticalScenarios.kt`
  - `calculateOrder()`：满减/折扣规则演示
  - `fetchUserNameById()`：返回 `ApiResult` 而不是直接抛异常
- `Collections.kt`
  - `topLogLevels()`：日志分组计数
- `NullSafety.kt`
  - `parseTimeoutMs()`：可空配置解析 + 默认值

---

## 5. 无 Gradle 测试方式

```bash
./scripts/test.sh
```

测试入口：`src/test/kotlin/ManualTests.kt`

你可以把这个文件当作“学习清单”：每个断言都是一个可验证知识点。

---

## 6. 下一步还可继续补充

- 协程与并发（超时/取消/结构化并发）
- 序列化（`kotlinx.serialization`）
- 文件 IO、日志规范
- 分层架构与错误码体系
- 更贴近生产的 CLI 命令解析
