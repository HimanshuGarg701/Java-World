package com.javaworld.leetcode;

public class P0211DesignAddAndSearchWordsDataStructure {
    private final TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;
        for (char letter : word.toCharArray()) {
            int index = letter - 'a';
            if (node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.word = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode node) {
        if (index == word.length()) return node.word;
        char letter = word.charAt(index);
        if (letter != '.') {
            TrieNode child = node.children[letter - 'a'];
            return child != null && search(word, index + 1, child);
        }
        for (TrieNode child : node.children) {
            if (child != null && search(word, index + 1, child)) return true;
        }
        return false;
    }

    private static final class TrieNode {
        private final TrieNode[] children = new TrieNode[26];
        private boolean word;
    }
}
