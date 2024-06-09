package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0017LetterCombinationsOfAPhoneNumber {
    private static final String[] LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (!digits.isEmpty()) build(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void build(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        for (char letter : LETTERS[digits.charAt(index) - '0'].toCharArray()) {
            current.append(letter);
            build(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}

