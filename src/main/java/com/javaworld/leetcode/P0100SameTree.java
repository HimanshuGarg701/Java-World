package com.javaworld.leetcode;

public class P0100SameTree {
    public boolean isSameTree(TreeNode first, TreeNode second) {
        if (first == null || second == null) return first == second;
        return first.val == second.val &&
                isSameTree(first.left, second.left) &&
                isSameTree(first.right, second.right);
    }
}
