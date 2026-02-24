# 16-kmp-demo（Kotlin Multiplatform 结构示例）

由于当前仓库约束是 **原生 kotlinc + JVM**，这里先给一个 KMP 目录设计示例，帮助你理解后续如何拆分：

```text
16-kmp-demo/
├── shared/
│   ├── commonMain/   # 跨平台业务逻辑
│   ├── jvmMain/      # JVM 平台实现
│   └── iosMain/      # iOS 平台实现
└── apps/
    ├── androidApp/
    └── iosApp/
```

建议你下一步把 `12-PracticalScenarios` 的纯业务逻辑迁移到 `shared/commonMain`，平台差异放到各自 `*Main`。
