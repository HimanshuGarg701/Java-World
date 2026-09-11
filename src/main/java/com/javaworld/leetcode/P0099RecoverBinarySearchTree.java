package com.javaworld.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P0099RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, previous = null, current = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (previous != null && previous.val > current.val) {
                if (first == null) first = previous;
                second = current;
            }
            previous = current;
            current = current.right;
        }
        int value = first.val;
        first.val = second.val;
        second.val = value;
    }
}

