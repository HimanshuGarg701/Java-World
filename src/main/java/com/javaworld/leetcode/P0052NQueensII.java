package com.javaworld.leetcode;

public class P0052NQueensII {
    public int totalNQueens(int n) {
        return count(0, n, 0L, 0L, 0L);
    }

    private int count(int row, int n, long columns, long descending, long ascending) {
        if (row == n) return 1;
        long available = ((1L << n) - 1) & ~(columns | descending | ascending);
        int solutions = 0;
        while (available != 0) {
            long position = available & -available;
            available -= position;
            solutions += count(row + 1, n, columns | position,
                    (descending | position) << 1, (ascending | position) >> 1);
        }
        return solutions;
    }
}

