package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0310MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        int[] degree = new int[n];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        List<Integer> leaves = new ArrayList<>();
        for (int node = 0; node < n; node++) if (degree[node] == 1) leaves.add(node);
        int remaining = n;
        while (remaining > 2) {
            remaining -= leaves.size();
            List<Integer> next = new ArrayList<>();
            for (int leaf : leaves) {
                for (int neighbor : graph.get(leaf)) {
                    if (--degree[neighbor] == 1) next.add(neighbor);
                }
            }
            leaves = next;
        }
        return leaves;
    }
}
