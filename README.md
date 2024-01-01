# Himanshu Java World

Himanshu Java World is a curated collection of 138 LeetCode solutions written in Java 17. Each solution is self-contained under `src/main/java/com/javaworld/leetcode`, apart from the shared `ListNode`, `TreeNode`, and `NestedInteger` support types used by linked-list, tree, and nested-list problems.

## Catalog

`manifest.tsv` is the source of truth for the collection. Its rows are in the deterministic randomized order intended for repository-history creation. The selection was produced from the available Java catalog with Python's `random.Random("HimanshuGarg701-java-world-2024-2026").sample(...)` over the sorted source paths.

The catalog contains implementation files only. It does not reproduce LeetCode problem statements or examples.

## Verify

Run the repository checks and compile every solution with Java 17:

```sh
./verify.sh
```

If Maven is installed, the project can also be compiled with:

```sh
mvn clean verify
```

## Historical-date disclosure

Any commit dates assigned from January 1, 2024 through October 21, 2026 are synthetic/backfilled research history created for this repository exercise. They do not represent the dates on which the problems were originally solved and should not be presented as contemporaneous contribution activity.

