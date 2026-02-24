#!/usr/bin/env bash
set -euo pipefail
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
PROJECT_DIR="$(cd "$SCRIPT_DIR/.." && pwd)"
OUT_DIR="$PROJECT_DIR/out"
mkdir -p "$OUT_DIR"
if ! command -v kotlinc >/dev/null 2>&1; then
  echo "[ERROR] kotlinc 未安装，请先安装 Kotlin 编译器。" >&2
  exit 1
fi
kotlinc "$PROJECT_DIR/src/main/kotlin" -include-runtime -d "$OUT_DIR/app.jar"
echo "Built: $OUT_DIR/app.jar"
