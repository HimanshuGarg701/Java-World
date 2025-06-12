package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0022GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        build(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void build(int n, int opened, int closed, StringBuilder current, List<String> result) {
        if (current.length() == n * 2) {
            result.add(current.toString());
            return;
        }
        if (opened < n) {
            current.append('(');
            build(n, opened + 1, closed, current, result);
            current.deleteCharAt(current.length() - 1);
        }
        if (closed < opened) {
            current.append(')');
            build(n, opened, closed + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}

