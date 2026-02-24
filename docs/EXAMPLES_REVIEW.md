# 代码示例完整性巡检（按 02 的标准）

> 巡检标准：
> 1. 是否解释了“为什么这样写”（注释/场景说明）
> 2. 是否覆盖同主题下的关键技术点（不仅是最小可运行）

## 结论（先说结果）

- 整体结构清晰、可运行，但大多数案例偏“最小演示”，注释较少。
- `02-VariablesAndTypes` 原先存在你提到的问题：只展示 `val/var`，没有说明差异与其他相关能力。
- 其他模块也有类似情况：能跑，但“教学解释”和“边界知识覆盖”不足。

## 分模块观察

### 01-BasicsRunner
- ✅ 优点：给了学习顺序。
- ⚠️ 不足：没有每章目标说明，读者不知道每章要掌握什么。

### 02-VariablesAndTypes
- ✅ 已改进：补充了 `val`、`var`、`const val`、可空类型、`lateinit`、`lazy` 与注释。

### 03-Modifiers
- ✅ 已涵盖：`open`/`override`/`protected`/`private`。
- ⚠️ 建议补充：`internal` 与模块边界说明。

### 04-Functions
- ✅ 已涵盖：默认参数、`vararg`、`infix`。
- ⚠️ 建议补充：具名参数、单表达式函数的取舍、`Unit` 返回。

### 05-ControlFlow
- ✅ 已涵盖：`if`、`for`、`when`。
- ⚠️ 建议补充：`when` 作为表达式返回值、`ranges/step/downTo`。

### 06-ClassesAndDataClasses
- ✅ 已涵盖：接口、`data class`、`companion object`。
- ⚠️ 建议补充：`copy`、解构、`init` 与次构造函数对比。

### 07-Collections
- ✅ 已涵盖：`groupingBy` + `eachCount` + 排序。
- ⚠️ 建议补充：`map/filter/fold` 的渐进式例子。

### 08-NullSafety
- ✅ 已涵盖：安全调用、Elvis、`toIntOrNull`。
- ⚠️ 建议补充：`let` 与早返回（`?: return`）场景。

### 09-Extensions
- ✅ 已涵盖：扩展函数。
- ⚠️ 建议补充：扩展函数不是“真的成员函数”的限制说明。

### 10-EnumsSealedResult
- ✅ 已涵盖：enum、sealed、`when`。
- ⚠️ 建议补充：`when` 穷尽性与不写 `else` 的好处。

### 11-LambdaGenericsScopes
- ✅ 已涵盖：泛型、lambda、`apply/let`。
- ⚠️ 建议补充：`also/run/with` 对比表。

### 12-PracticalScenarios
- ✅ 已涵盖：业务规则函数。
- ⚠️ 建议补充：金额计算建议用 `BigDecimal`（避免 `Double` 精度问题）。

### 13-ImportantPatterns
- ✅ 已涵盖：`lazy`、`Result`、`runCatching`。
- ⚠️ 建议补充：`Result` 的链式处理（`mapCatching/recover`）。

## 推荐改造策略

1. 每章新增三段固定结构：
   - `// 场景`
   - `// 语法点`
   - `// 常见坑`
2. 每章至少覆盖“主语法 + 1 个边界点”。
3. 每章最后打印一行“总结输出”，方便初学者对照。

