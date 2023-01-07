#!/usr/bin/env bash

IFS="," read -ra PORTS <<<"$WAIT_PORTS"

echo "Sleeping for 30 seconds"
sleep 90
echo "Wake up"


PIDs=()
for port in "${PORTS[@]}"; do
  echo "Starts health checking..."
  "$(pwd)"/scripts/wait-for.sh -t 120 "http://localhost:$port/manage/health" -- echo "Host localhost:$port is active" &
  PIDs+=($!)
  echo "Health checking complete!"
done


for pid in "${PIDs[@]}"; do
  if ! wait "${pid}"; then
    exit 1
  fi
done