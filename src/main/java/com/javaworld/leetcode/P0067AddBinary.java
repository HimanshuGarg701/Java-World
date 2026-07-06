package com.javaworld.leetcode;

public class P0067AddBinary {
    public String addBinary(String first, String second) {
        StringBuilder reversed = new StringBuilder();
        int i = first.length() - 1, j = second.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += first.charAt(i--) - '0';
            if (j >= 0) sum += second.charAt(j--) - '0';
            reversed.append(sum & 1);
            carry = sum >> 1;
        }
        return reversed.reverse().toString();
    }
}

