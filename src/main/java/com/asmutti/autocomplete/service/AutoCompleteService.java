package com.asmutti.autocomplete.service;

import com.asmutti.autocomplete.trie.Trie;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class AutoCompleteService {

    private final Trie trie;

    public AutoCompleteService(Trie trie) {
        this.trie = trie;
    }

    /**
     * Get suggestions for the given query, using the trie data structure.
     * All queries are converted to lowercase before processing.
     * @param query
     * @return
     */
    public List<String> getSuggestions(String query) {
        log.info("Getting suggestions for: {}", query);

        var result = trie.suggest(query.toLowerCase());

        log.info("Found {} suggestions", result.size());

        return result;
    }
}
