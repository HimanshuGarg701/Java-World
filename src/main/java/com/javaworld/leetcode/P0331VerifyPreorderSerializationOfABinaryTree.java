package com.javaworld.leetcode;

public class P0331VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        int slots = 1;
        for (String node : preorder.split(",")) {
            if (slots == 0) return false;
            slots--;
            if (!node.equals("#")) slots += 2;
        }
        return slots == 0;
    }
}
