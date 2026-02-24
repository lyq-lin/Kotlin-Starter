#!/usr/bin/env bash
set -euo pipefail
ROOT_DIR="$(cd "$(dirname "$0")/.." && pwd)"
OUT_DIR="$ROOT_DIR/out"
JAR_PATH="$OUT_DIR/ai-cli-demo.jar"
mkdir -p "$OUT_DIR"
if ! command -v kotlinc >/dev/null 2>&1; then
  echo "Error: kotlinc 未安装，无法编译 02-ai-cli。"
  exit 1
fi
mapfile -t SRC < <(find "$ROOT_DIR/src/main/kotlin" -name '*.kt' | sort)
kotlinc "${SRC[@]}" -include-runtime -d "$JAR_PATH"
echo "Build success: $JAR_PATH"
