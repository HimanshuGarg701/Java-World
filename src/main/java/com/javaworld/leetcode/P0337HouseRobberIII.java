package com.javaworld.leetcode;

public class P0337HouseRobberIII {
    public int rob(TreeNode root) {
        int[] choices = visit(root);
        return Math.max(choices[0], choices[1]);
    }

    private int[] visit(TreeNode node) {
        if (node == null) return new int[2];
        int[] left = visit(node.left);
        int[] right = visit(node.right);
        int take = node.val + left[1] + right[1];
        int skip = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{take, skip};
    }
}
