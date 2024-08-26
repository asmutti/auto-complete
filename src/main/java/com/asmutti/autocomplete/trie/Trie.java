package com.asmutti.autocomplete.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    TrieNode root;

    public Trie(List<String> words) {
        root = new TrieNode();
        for (String word : words)
            root.insert(word);
    }

    private void suggestHelper(TrieNode root, List<String> list, StringBuffer curr) {
        if (root.isWord()) {
            list.add(curr.toString());
        }

        if (root.getChildren() == null || root.getChildren().isEmpty())
            return;

        for (TrieNode child : root.getChildren().values()) {
            suggestHelper(child, list, curr.append(child.getCharacter()));
            curr.setLength(curr.length() - 1);
        }
    }

    public List<String> suggest(String prefix) {
        var list = new ArrayList<String>();
        var lastNode = root;
        var curr = new StringBuffer();
        for (char ch : prefix.toCharArray()) {
            lastNode = lastNode.getChildren().get(ch);
            if (lastNode == null) {
                return list;
            }
            curr.append(ch);
        }
        suggestHelper(lastNode, list, curr);
        return list;
    }
}
