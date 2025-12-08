package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0095UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return n == 0 ? new ArrayList<>() : build(1, n);
    }

    private List<TreeNode> build(int low, int high) {
        List<TreeNode> trees = new ArrayList<>();
        if (low > high) {
            trees.add(null);
            return trees;
        }
        for (int rootValue = low; rootValue <= high; rootValue++) {
            for (TreeNode left : build(low, rootValue - 1)) {
                for (TreeNode right : build(rootValue + 1, high)) {
                    trees.add(new TreeNode(rootValue, left, right));
                }
            }
        }
        return trees;
    }
}

