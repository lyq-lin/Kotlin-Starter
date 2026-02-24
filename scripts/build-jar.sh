#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "$0")/.." && pwd)"
OUT_DIR="$ROOT_DIR/out"
JAR_PATH="$OUT_DIR/kotlin-starter.jar"

mkdir -p "$OUT_DIR"

mapfile -t SRC_FILES < <(find "$ROOT_DIR/src/main/kotlin" -name '*.kt' | sort)

if ! command -v kotlinc >/dev/null 2>&1; then
  echo "Error: kotlinc 未安装，无法原生编译。"
  echo "请先安装 Kotlin 编译器后重试。"
  exit 1
fi

kotlinc "${SRC_FILES[@]}" -include-runtime -d "$JAR_PATH"
echo "Build success: $JAR_PATH"
