package com.javaworld.leetcode;

public class P0096UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] trees = new int[n + 1];
        trees[0] = 1;
        for (int nodes = 1; nodes <= n; nodes++) {
            for (int leftNodes = 0; leftNodes < nodes; leftNodes++) {
                trees[nodes] += trees[leftNodes] * trees[nodes - leftNodes - 1];
            }
        }
        return trees[n];
    }
}

