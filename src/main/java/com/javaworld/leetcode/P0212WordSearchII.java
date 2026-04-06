package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0212WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) insert(root, word);
        List<String> result = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                search(board, row, column, root, result);
            }
        }
        return result;
    }

    private void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char letter : word.toCharArray()) {
            int index = letter - 'a';
            if (node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.word = word;
    }

    private void search(char[][] board, int row, int column, TrieNode node, List<String> result) {
        if (row < 0 || row == board.length || column < 0 || column == board[0].length) return;
        char letter = board[row][column];
        if (letter == '#') return;
        TrieNode child = node.children[letter - 'a'];
        if (child == null) return;
        if (child.word != null) {
            result.add(child.word);
            child.word = null;
        }
        board[row][column] = '#';
        search(board, row + 1, column, child, result);
        search(board, row - 1, column, child, result);
        search(board, row, column + 1, child, result);
        search(board, row, column - 1, child, result);
        board[row][column] = letter;
    }

    private static final class TrieNode {
        private final TrieNode[] children = new TrieNode[26];
        private String word;
    }
}
