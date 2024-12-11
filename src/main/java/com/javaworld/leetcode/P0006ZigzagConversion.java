package com.javaworld.leetcode;

public class P0006ZigzagConversion {
    public String convert(String s, int rows) {
        if (rows == 1 || rows >= s.length()) return s;
        StringBuilder[] lines = new StringBuilder[rows];
        for (int i = 0; i < rows; i++) lines[i] = new StringBuilder();
        int row = 0, direction = 1;
        for (char c : s.toCharArray()) {
            lines[row].append(c);
            if (row == 0) direction = 1;
            else if (row == rows - 1) direction = -1;
            row += direction;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder line : lines) result.append(line);
        return result.toString();
    }
}

