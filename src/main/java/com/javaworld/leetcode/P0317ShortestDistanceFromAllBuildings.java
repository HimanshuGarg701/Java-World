package com.javaworld.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class P0317ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] distances = new int[rows][columns];
        int[][] reaches = new int[rows][columns];
        int buildings = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] != 1) continue;
                buildings++;
                boolean[][] visited = new boolean[rows][columns];
                Queue<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{row, column, 0});
                visited[row][column] = true;
                while (!queue.isEmpty()) {
                    int[] current = queue.remove();
                    for (int[] direction : directions) {
                        int nextRow = current[0] + direction[0];
                        int nextColumn = current[1] + direction[1];
                        if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns
                                || visited[nextRow][nextColumn] || grid[nextRow][nextColumn] != 0) continue;
                        visited[nextRow][nextColumn] = true;
                        distances[nextRow][nextColumn] += current[2] + 1;
                        reaches[nextRow][nextColumn]++;
                        queue.add(new int[]{nextRow, nextColumn, current[2] + 1});
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == 0 && reaches[row][column] == buildings) {
                    answer = Math.min(answer, distances[row][column]);
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
