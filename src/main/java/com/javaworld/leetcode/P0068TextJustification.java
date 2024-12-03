package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0068TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        for (int start = 0; start < words.length;) {
            int end = start, letters = 0;
            while (end < words.length && letters + words[end].length() + end - start <= maxWidth) {
                letters += words[end++].length();
            }
            int gaps = end - start - 1;
            boolean lastLine = end == words.length;
            StringBuilder line = new StringBuilder();
            if (gaps == 0 || lastLine) {
                for (int i = start; i < end; i++) {
                    if (i > start) line.append(' ');
                    line.append(words[i]);
                }
                line.append(" ".repeat(maxWidth - line.length()));
            } else {
                int spaces = maxWidth - letters;
                int each = spaces / gaps, extra = spaces % gaps;
                for (int i = start; i < end; i++) {
                    line.append(words[i]);
                    if (i < end - 1) line.append(" ".repeat(each + (i - start < extra ? 1 : 0)));
                }
            }
            result.add(line.toString());
            start = end;
        }
        return result;
    }
}

