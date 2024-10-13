package com.javaworld.leetcode;

public class P0098ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        if (node.val <= lower || node.val >= upper) return false;
        return valid(node.left, lower, node.val) && valid(node.right, node.val, upper);
    }
}

