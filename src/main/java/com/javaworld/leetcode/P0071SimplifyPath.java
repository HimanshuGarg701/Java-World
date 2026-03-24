package com.javaworld.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P0071SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> directories = new ArrayDeque<>();
        for (String part : path.split("/")) {
            if (part.isEmpty() || part.equals(".")) continue;
            if (part.equals("..")) {
                if (!directories.isEmpty()) directories.removeLast();
            } else directories.addLast(part);
        }
        return "/" + String.join("/", directories);
    }
}

