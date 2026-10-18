#!/bin/sh
set -eu

repository_dir=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
cd "$repository_dir"

manifest=manifest.tsv
solutions_dir=src/main/java/com/javaworld/leetcode
expected_solutions=161
expected_header=$(printf 'problem_number\trelative_path\ttitle')

fail() {
    printf 'Verification failed: %s\n' "$1" >&2
    exit 1
}

[ -f "$manifest" ] || fail "missing $manifest"
[ "$(sed -n '1p' "$manifest")" = "$expected_header" ] || fail "invalid manifest header"

manifest_count=$(awk 'NR > 1 { count++ } END { print count + 0 }' "$manifest")
[ "$manifest_count" -eq "$expected_solutions" ] || fail "expected $expected_solutions manifest entries, found $manifest_count"

duplicate_numbers=$(awk -F '\t' 'NR > 1 { print $1 }' "$manifest" | sort | uniq -d | wc -l | tr -d ' ')
[ "$duplicate_numbers" -eq 0 ] || fail "manifest contains duplicate problem numbers"

duplicate_paths=$(awk -F '\t' 'NR > 1 { print $2 }' "$manifest" | sort | uniq -d | wc -l | tr -d ' ')
[ "$duplicate_paths" -eq 0 ] || fail "manifest contains duplicate paths"

awk -F '\t' '
    NR == 1 { next }
    NF != 3 || $1 !~ /^[0-9]+$/ || $2 == "" || $3 == "" { exit 1 }
' "$manifest" || fail "manifest contains a malformed row"

while IFS="$(printf '\t')" read -r problem_number relative_path title; do
    [ "$problem_number" = "problem_number" ] && continue
    [ -f "$relative_path" ] || fail "missing catalog file $relative_path"
    padded_number=$(printf '%04d' "$problem_number")
    case "$(basename -- "$relative_path")" in
        "P${padded_number}"*.java) ;;
        *) fail "problem number $problem_number does not match $relative_path" ;;
    esac
done < "$manifest"

actual_solutions=$(find "$solutions_dir" -maxdepth 1 -type f -name 'P*.java' | wc -l | tr -d ' ')
[ "$actual_solutions" -eq "$expected_solutions" ] || fail "expected $expected_solutions solution files, found $actual_solutions"

for support_type in ListNode.java TreeNode.java NestedInteger.java; do
    [ -f "$solutions_dir/$support_type" ] || fail "missing support type $support_type"
done

unexpected_files=$(find "$solutions_dir" -maxdepth 1 -type f ! -name 'P*.java' ! -name 'ListNode.java' ! -name 'TreeNode.java' ! -name 'NestedInteger.java' -print)
[ -z "$unexpected_files" ] || fail "unexpected Java catalog files found"

build_dir=$(mktemp -d "${TMPDIR:-/tmp}/himanshu-java-world.XXXXXX")
trap 'rm -rf "$build_dir"' EXIT HUP INT TERM
find "$solutions_dir" -maxdepth 1 -type f -name '*.java' -print | sort > "$build_dir/sources.txt"
javac --release 17 -encoding UTF-8 -d "$build_dir/classes" @"$build_dir/sources.txt"

printf 'Verified %s Java solutions and compiled the complete catalog.\n' "$expected_solutions"
