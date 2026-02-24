#!/usr/bin/env bash
set -euo pipefail
for p in projects/0* projects/1*; do
  [ -d "$p/scripts" ] || continue
  [ -x "$p/scripts/build.sh" ] || continue
  echo "==> building $p"
  "$p/scripts/build.sh"
done
