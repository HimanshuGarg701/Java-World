package com.javaworld.leetcode;

public class P0043MultiplyStrings {
    public String multiply(String first, String second) {
        if (first.equals("0") || second.equals("0")) return "0";
        int[] digits = new int[first.length() + second.length()];
        for (int i = first.length() - 1; i >= 0; i--) {
            for (int j = second.length() - 1; j >= 0; j--) {
                int position = i + j + 1;
                int product = (first.charAt(i) - '0') * (second.charAt(j) - '0') + digits[position];
                digits[position] = product % 10;
                digits[position - 1] += product / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        int index = digits[0] == 0 ? 1 : 0;
        while (index < digits.length) result.append(digits[index++]);
        return result.toString();
    }
}

