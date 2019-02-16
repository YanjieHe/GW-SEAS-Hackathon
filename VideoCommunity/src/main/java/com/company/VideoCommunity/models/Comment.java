package com.company.VideoCommunity.models;

public class Comment {
    public int id;
    public String text;
    public float score;

    public Comment(int id, String text, float score) {
        this.id = id;
        this.text = text;
        this.score = score;
    }
}
