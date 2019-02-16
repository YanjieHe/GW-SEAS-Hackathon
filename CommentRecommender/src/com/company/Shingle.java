package com.company;

public class Shingle {
    public String[] words;
    public int hashCache;

    public Shingle(String[] words) {
        this.words = words;
        this.hashCache = calculateHash();
    }

    public int calculateHash() {
        int hash = 0;
        for (String word : words) {
            hash = hash ^ word.hashCode();
        }
        return hash;
    }

    @Override
    public int hashCode() {
        return hashCache;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Shingle) {
            Shingle other = (Shingle) o;
            if (words.length == other.words.length) {
                for (int i = 0; i < words.length; i++) {
                    if (!words[i].equals(other.words[i])) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "(" + String.join(", ", words) + ")";
    }
}
