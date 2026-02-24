#!/usr/bin/env bash
set -euo pipefail
ROOT_DIR="$(cd "$(dirname "$0")/.." && pwd)"
OUT_DIR="$ROOT_DIR/out/tests"
mkdir -p "$OUT_DIR"
if ! command -v kotlinc >/dev/null 2>&1; then
  echo "Error: kotlinc 未安装，无法执行 01-basics 测试。"
  exit 1
fi
mapfile -t MAIN_SRC < <(find "$ROOT_DIR/src/main/kotlin" -name '*.kt' | sort)
kotlinc "${MAIN_SRC[@]}" "$ROOT_DIR/src/test/kotlin/ManualTests.kt" -include-runtime -d "$OUT_DIR/manual-tests.jar"
java -jar "$OUT_DIR/manual-tests.jar"
