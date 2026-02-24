# Kotlin 完全入门仓库（多项目结构）

你提的建议非常好：**一个仓库里拆多个项目/文件夹**，可读性更高、学习路径更原子化。

我已经把仓库重构成了多项目结构：

```text
projects/
├── 01-basics/      # 纯 Kotlin 语法与日常开发案例
└── 02-ai-cli/      # Koog 风格 AI CLI（可替换真实 SDK）
```

---

## 为什么拆分更好

- **原子化学习**：先学 `01-basics`，再看 `02-ai-cli`，避免一上来被太多概念干扰。
- **职责清晰**：语法示例和应用示例解耦，不互相污染。
- **可扩展**：后续你可以继续新增 `03-coroutines`、`04-serialization` 等目录。

---

## 1) 项目一：`01-basics`

路径：`projects/01-basics`

包含：
- 变量/类型、修饰符、函数、分支循环
- 类/接口/object、集合、空安全、扩展函数
- enum + sealed、泛型 + lambda + scope functions
- 实战案例（订单计算、接口结果处理、日志聚合、配置兜底）
- 重要模式（Result/runCatching、Sequence、委托、lazy）

运行：

```bash
./projects/01-basics/scripts/run.sh
```

测试：

```bash
./projects/01-basics/scripts/test.sh
```

---

## 2) 项目二：`02-ai-cli`

路径：`projects/02-ai-cli`

包含：
- `AiClient` 接口（便于后续替换真实 Koog SDK）
- `AiCliApp` 交互循环
- `Config` 环境变量读取（`KOOG_API_KEY` / `KOOG_MODEL` / `KOOG_BASE_URL`）

运行：

```bash
export KOOG_API_KEY="your_api_key"
export KOOG_MODEL="gpt-4o-mini"
export KOOG_BASE_URL="https://api.openai.com/v1"
./projects/02-ai-cli/scripts/run.sh
```

---

## 3) 根目录快捷脚本（聚合入口）

- `./scripts/build-jar.sh`：构建两个项目
- `./scripts/run-basics.sh`：运行 `01-basics`
- `./scripts/run-ai.sh`：运行 `02-ai-cli`
- `./scripts/test.sh`：运行 `01-basics` 手工测试

---

## 4) 环境要求

- JDK 17+
- `kotlinc`

```bash
java -version
kotlinc -version
```

---

## 5) 下一步建议（继续多项目化）

你可以按学习阶段继续扩展：

- `projects/03-coroutines`：协程、取消、超时、结构化并发
- `projects/04-serialization`：JSON 序列化与反序列化
- `projects/05-testing`：mock、分层测试、测试数据工厂
