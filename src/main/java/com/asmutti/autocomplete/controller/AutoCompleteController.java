package com.asmutti.autocomplete.controller;

import com.asmutti.autocomplete.service.AutoCompleteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AutoCompleteController {

    private final AutoCompleteService autoCompleteService;

    public AutoCompleteController(AutoCompleteService autoCompleteService) {
        this.autoCompleteService = autoCompleteService;
    }

    @GetMapping("/autocomplete")
    public ResponseEntity<Object> autocomplete(@RequestParam String query) {
        if (query == null || query.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        List<String> suggestions = autoCompleteService.getSuggestions(query);
        return ResponseEntity.ok(suggestions);
    }
}
