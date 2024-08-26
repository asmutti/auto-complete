package com.asmutti.autocomplete.config;

import com.asmutti.autocomplete.trie.Trie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TrieConfig {

    @Bean
    public Trie trie() {
        return new Trie(Arrays.asList(
                "JavaScript",
                "Python",
                "Java",
                "C#",
                "C",
                "C++",
                "TypeScript",
                "PHP",
                "Swift",
                "Ruby",
                "Objective-C",
                "Kotlin",
                "Go",
                "Rust",
                "Scala",
                "Perl",
                "Haskell",
                "Lua",
                "MATLAB",
                "R",
                "Dart",
                "Elixir",
                "F#",
                "Clojure",
                "Shell",
                "PowerShell",
                "Groovy",
                "Visual Basic",
                "Assembly",
                "SQL",
                "SAS",
                "COBOL",
                "Fortran",
                "Ada",
                "Lisp",
                "Prolog",
                "Erlang",
                "Scheme",
                "Julia",
                "VHDL",
                "Verilog",
                "ABAP",
                "Scratch",
                "ActionScript",
                "Smalltalk",
                "Tcl",
                "D",
                "Delphi",
                "Pascal",
                "Lua"
        ));
    }
 }
