package com.javaworld.leetcode;

public class P0306AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        int length = num.length();
        for (int firstEnd = 1; firstEnd <= length - 2; firstEnd++) {
            if (num.charAt(0) == '0' && firstEnd > 1) break;
            for (int secondEnd = firstEnd + 1; secondEnd < length; secondEnd++) {
                if (num.charAt(firstEnd) == '0' && secondEnd - firstEnd > 1) break;
                String first = num.substring(0, firstEnd);
                String second = num.substring(firstEnd, secondEnd);
                int index = secondEnd;
                while (index < length) {
                    String sum = add(first, second);
                    if (!num.startsWith(sum, index)) break;
                    index += sum.length();
                    first = second;
                    second = sum;
                }
                if (index == length) return true;
            }
        }
        return false;
    }

    private String add(String first, String second) {
        StringBuilder result = new StringBuilder();
        int i = first.length() - 1;
        int j = second.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += first.charAt(i--) - '0';
            if (j >= 0) sum += second.charAt(j--) - '0';
            result.append(sum % 10);
            carry = sum / 10;
        }
        return result.reverse().toString();
    }
}
