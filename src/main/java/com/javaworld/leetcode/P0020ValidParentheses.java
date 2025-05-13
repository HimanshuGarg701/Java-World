package com.javaworld.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P0020ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> expected = new ArrayDeque<>();
        for (char symbol : s.toCharArray()) {
            if (symbol == '(') expected.push(')');
            else if (symbol == '[') expected.push(']');
            else if (symbol == '{') expected.push('}');
            else if (expected.isEmpty() || expected.pop() != symbol) return false;
        }
        return expected.isEmpty();
    }
}
