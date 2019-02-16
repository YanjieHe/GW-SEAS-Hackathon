package com.company;

import java.util.ArrayList;

public class Tokenizer {
    public static ArrayList<Token> tokenize(String text) {
        ArrayList<Token> tokens = new ArrayList<>();
        int index = 0;
        for (String item : text.split("[^a-zA-Z0-9]")) {
            tokens.add(new Token(item, index));
            index = index + 1;
        }
        return tokens;
    }
}
