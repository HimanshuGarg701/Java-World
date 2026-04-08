package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0320GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        build(word, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void build(String word, int index, int abbreviated, StringBuilder current, List<String> result) {
        int originalLength = current.length();
        if (index == word.length()) {
            if (abbreviated > 0) current.append(abbreviated);
            result.add(current.toString());
            current.setLength(originalLength);
            return;
        }
        build(word, index + 1, abbreviated + 1, current, result);
        if (abbreviated > 0) current.append(abbreviated);
        current.append(word.charAt(index));
        build(word, index + 1, 0, current, result);
        current.setLength(originalLength);
    }
}
