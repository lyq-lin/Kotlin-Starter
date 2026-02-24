#!/usr/bin/env bash
set -euo pipefail
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
"$SCRIPT_DIR/build.sh"
java -jar "$(cd "$SCRIPT_DIR/.." && pwd)/out/app.jar" "$@"
