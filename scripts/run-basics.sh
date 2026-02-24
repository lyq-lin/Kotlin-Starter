#!/usr/bin/env bash
set -euo pipefail
ROOT_DIR="$(cd "$(dirname "$0")/.." && pwd)"
"$ROOT_DIR/scripts/build-jar.sh"
java -jar "$ROOT_DIR/out/kotlin-starter.jar" basics
