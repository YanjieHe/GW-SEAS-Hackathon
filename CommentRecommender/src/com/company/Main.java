package com.company;

import java.util.ArrayList;

import static java.lang.System.out;

public class Main {

    public static ArrayList<Shingle> commentToShingles(Comment comment) {
        ArrayList<Token> tokens = Tokenizer.tokenize(comment.text);
        ArrayList<Shingle> shingles = TextSimilarity.shingles(tokens, 3);
        for (Shingle shingle : shingles) {
            out.println(shingle);
        }
        return shingles;
    }

    public static void main(String[] args) {
        Comment comment1 = new Comment(0, "w1 w5 w3 w1 w7 w4 w5 w1 w6", 3);
        Comment comment2 = new Comment(1, "w7 w3 w1 w7 w4 w5 w1 w8 w6", 4);
        ArrayList<Shingle> shingles1 = commentToShingles(comment1);
        ArrayList<Shingle> shingles2 = commentToShingles(comment2);
        out.println("similarity = " + TextSimilarity.similarity(shingles1, shingles2));
    }
}
