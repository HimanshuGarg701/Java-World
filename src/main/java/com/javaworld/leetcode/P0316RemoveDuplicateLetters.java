package com.javaworld.leetcode;

public class P0316RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] remaining = new int[26];
        boolean[] used = new boolean[26];
        for (char c : s.toCharArray()) remaining[c - 'a']++;
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            remaining[index]--;
            if (used[index]) continue;
            while (!stack.isEmpty()) {
                char last = stack.charAt(stack.length() - 1);
                if (last <= c || remaining[last - 'a'] == 0) break;
                used[last - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }
            stack.append(c);
            used[index] = true;
        }
        return stack.toString();
    }
}
