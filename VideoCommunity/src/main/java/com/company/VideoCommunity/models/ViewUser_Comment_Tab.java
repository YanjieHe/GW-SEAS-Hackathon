package com.company.VideoCommunity.models;

import java.io.Serializable;

public class ViewUser_Comment_Tab implements Serializable {

    private User user;
    private VideoComment videoComment;
    private VideoTab videoTab;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VideoComment getVideoComment() {
        return videoComment;
    }

    public void setVideoComment(VideoComment videoComment) {
        this.videoComment = videoComment;
    }

    public VideoTab getVideoTab() {
        return videoTab;
    }

    public void setVideoTab(VideoTab videoTab) {
        this.videoTab = videoTab;
    }
}
