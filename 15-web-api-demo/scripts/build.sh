#!/usr/bin/env bash
set -euo pipefail
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
PROJECT_DIR="$(cd "$SCRIPT_DIR/.." && pwd)"
OUT_DIR="$PROJECT_DIR/out"
mkdir -p "$OUT_DIR"
command -v kotlinc >/dev/null 2>&1 || { echo "[ERROR] kotlinc 未安装" >&2; exit 1; }
kotlinc "$PROJECT_DIR/src/main/kotlin" -include-runtime -d "$OUT_DIR/app.jar"
