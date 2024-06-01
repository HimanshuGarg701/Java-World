package com.javaworld.leetcode;

public class P0345ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] values = s.toCharArray();
        int left = 0;
        int right = values.length - 1;
        while (left < right) {
            while (left < right && !isVowel(values[left])) left++;
            while (left < right && !isVowel(values[right])) right--;
            char swap = values[left];
            values[left++] = values[right];
            values[right--] = swap;
        }
        return new String(values);
    }

    private boolean isVowel(char value) {
        return "aeiouAEIOU".indexOf(value) >= 0;
    }
}
