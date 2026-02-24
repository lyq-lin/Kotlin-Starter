#!/usr/bin/env bash
set -euo pipefail
for m in modules/*; do
  [ -d "$m/scripts" ] || continue
  [ -x "$m/scripts/build.sh" ] || continue
  echo "==> building $m"
  "$m/scripts/build.sh"
done
