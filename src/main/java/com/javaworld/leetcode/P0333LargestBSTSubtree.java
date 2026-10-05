package com.javaworld.leetcode;

public class P0333LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        return inspect(root).largest;
    }

    private Summary inspect(TreeNode node) {
        if (node == null) return new Summary(true, 0, Long.MAX_VALUE, Long.MIN_VALUE, 0);
        Summary left = inspect(node.left);
        Summary right = inspect(node.right);
        if (left.bst && right.bst && left.maximum < node.val && node.val < right.minimum) {
            int size = left.size + right.size + 1;
            return new Summary(true, size, Math.min(left.minimum, node.val),
                    Math.max(right.maximum, node.val), size);
        }
        return new Summary(false, 0, 0, 0, Math.max(left.largest, right.largest));
    }

    private record Summary(boolean bst, int size, long minimum, long maximum, int largest) {}
}
