package com.javaworld.leetcode;

public class P0038CountAndSay {
    public String countAndSay(int n) {
        String value = "1";
        for (int round = 1; round < n; round++) {
            StringBuilder next = new StringBuilder();
            for (int start = 0; start < value.length();) {
                int end = start + 1;
                while (end < value.length() && value.charAt(end) == value.charAt(start)) end++;
                next.append(end - start).append(value.charAt(start));
                start = end;
            }
            value = next.toString();
        }
        return value;
    }
}

