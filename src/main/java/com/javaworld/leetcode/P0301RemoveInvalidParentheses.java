package com.javaworld.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class P0301RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        queue.add(s);
        seen.add(s);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean found = false;
            for (int item = 0; item < levelSize; item++) {
                String current = queue.remove();
                if (isValid(current)) {
                    result.add(current);
                    found = true;
                }
                if (found) continue;
                for (int i = 0; i < current.length(); i++) {
                    char value = current.charAt(i);
                    if (value != '(' && value != ')') continue;
                    String next = current.substring(0, i) + current.substring(i + 1);
                    if (seen.add(next)) queue.add(next);
                }
            }
            if (found) break;
        }
        return result;
    }

    private boolean isValid(String value) {
        int balance = 0;
        for (char c : value.toCharArray()) {
            if (c == '(') balance++;
            if (c == ')' && --balance < 0) return false;
        }
        return balance == 0;
    }
}
