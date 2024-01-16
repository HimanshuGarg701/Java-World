package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0305NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[m * n];
        int[] size = new int[m * n];
        Arrays.fill(parent, -1);
        List<Integer> result = new ArrayList<>();
        int islands = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] position : positions) {
            int row = position[0];
            int column = position[1];
            int index = row * n + column;
            if (parent[index] != -1) {
                result.add(islands);
                continue;
            }
            parent[index] = index;
            size[index] = 1;
            islands++;
            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextColumn = column + direction[1];
                if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n) continue;
                int neighbor = nextRow * n + nextColumn;
                if (parent[neighbor] == -1) continue;
                int first = find(parent, index);
                int second = find(parent, neighbor);
                if (first == second) continue;
                if (size[first] < size[second]) {
                    int swap = first;
                    first = second;
                    second = swap;
                }
                parent[second] = first;
                size[first] += size[second];
                islands--;
            }
            result.add(islands);
        }
        return result;
    }

    private int find(int[] parent, int node) {
        while (node != parent[node]) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }
}
