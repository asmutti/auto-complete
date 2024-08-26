package com.asmutti.autocomplete.trie;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class TrieNode {
    private final Map<Character, TrieNode> children;
    private char character;
    private boolean isWord;

    public TrieNode(char character) {
        this.character = character;
        children = new HashMap<>();
    }

    public TrieNode() {
        children = new HashMap<>();
    }

    public void insert(String word) {
        var lowerCaseWord = word.toLowerCase();

        if (lowerCaseWord.isEmpty()) {
            return;
        }

        var firstChar = lowerCaseWord.charAt(0);
        var child = children.computeIfAbsent(firstChar, TrieNode::new);

        if (lowerCaseWord.length() > 1) {
            child.insert(lowerCaseWord.substring(1));
        }
        else {
            child.isWord = true;
        }
    }
}
