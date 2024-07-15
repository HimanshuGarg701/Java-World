package com.javaworld.leetcode;

public class P0323NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int node = 0; node < n; node++) {
            parent[node] = node;
            size[node] = 1;
        }
        int components = n;
        for (int[] edge : edges) {
            int first = find(parent, edge[0]);
            int second = find(parent, edge[1]);
            if (first == second) continue;
            if (size[first] < size[second]) {
                int swap = first;
                first = second;
                second = swap;
            }
            parent[second] = first;
            size[first] += size[second];
            components--;
        }
        return components;
    }

    private int find(int[] parent, int node) {
        while (parent[node] != node) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }
}
