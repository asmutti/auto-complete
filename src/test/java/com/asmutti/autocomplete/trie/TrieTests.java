package com.asmutti.autocomplete.trie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrieTests {
    private Trie trie;

    @BeforeEach
    public void setUp() {
        var words = List.of("java", "javascript", "julia");
        trie = new Trie(words);
    }

    @Test
    public void testSuggest() {
        var suggestions = trie.suggest("j");

        assertTrue(suggestions.contains("java"));
    }

    @Test
    public void testSuggestNoMatch() {
        var suggestions = trie.suggest("xyz");

        assertTrue(suggestions.isEmpty());
    }
}
