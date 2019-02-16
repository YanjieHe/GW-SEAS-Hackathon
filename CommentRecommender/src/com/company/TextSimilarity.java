package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class TextSimilarity {
    public static ArrayList<Shingle> shingles(ArrayList<Token> tokens, int n) {
        ArrayList<Shingle> shingleArrayList = new ArrayList<>();
        for (int i = 0; i < tokens.size() - n + 1; i++) {
            String[] words = new String[n];
            for (int j = 0; j < words.length; j++) {
                words[j] = tokens.get(i + j).text;
            }
            shingleArrayList.add(new Shingle(words));
        }
        return shingleArrayList;
    }

    public static double similarity(ArrayList<Shingle> shingles1, ArrayList<Shingle> shingles2) {
        HashSet<Shingle> shingleHashSet1 = new HashSet<>();
        for (Shingle shingle : shingles1) {
            shingleHashSet1.add(shingle);
        }
        HashSet<Shingle> shingleHashSet2 = new HashSet<>();
        for (Shingle shingle : shingles2) {
            shingleHashSet2.add(shingle);
        }
        HashSet<Shingle> result = new HashSet<>();
        for (Shingle shingle : shingleHashSet1) {
            if (shingleHashSet2.contains(shingle)) {
                result.add(shingle);
            }
        }
        double n = result.size();
        return n / (shingleHashSet1.size() + shingleHashSet2.size() - n);
    }

    public static void sortComments(int n, Comment comment, ArrayList<Comment> comments) {
        HashMap<Integer, Double> similarityMap = new HashMap<>();
        ArrayList<Shingle> shingles1 = shingles(Tokenizer.tokenize(comment.text), n);
        for (Comment c : comments) {
            ArrayList<Shingle> shingles2 = shingles(Tokenizer.tokenize(c.text), n);
            similarityMap.put(c.id, similarity(shingles1, shingles2));
        }
        comments.sort(new Comparator<Comment>() {
            @Override
            public int compare(Comment comment, Comment t1) {
                return similarityMap.get(comment.id).compareTo(similarityMap.get(t1.id));
            }
        });
    }
}
