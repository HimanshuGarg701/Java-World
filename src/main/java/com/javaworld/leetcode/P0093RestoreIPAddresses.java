package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0093RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        build(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void build(String s, int index, int parts, StringBuilder address, List<String> result) {
        if (parts == 4) {
            if (index == s.length()) result.add(address.substring(0, address.length() - 1));
            return;
        }
        int remaining = s.length() - index;
        if (remaining < 4 - parts || remaining > (4 - parts) * 3) return;
        int originalLength = address.length();
        int value = 0;
        for (int end = index; end < Math.min(index + 3, s.length()); end++) {
            if (end > index && s.charAt(index) == '0') break;
            value = value * 10 + s.charAt(end) - '0';
            if (value > 255) break;
            address.append(value).append('.');
            build(s, end + 1, parts + 1, address, result);
            address.setLength(originalLength);
        }
    }
}

