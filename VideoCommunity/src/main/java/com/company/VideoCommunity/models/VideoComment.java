package com.company.VideoCommunity.models;


public class VideoComment {

    private Integer video_comment_id;

    private Integer comment_tab_user_id;

    private Integer video_id;

    private Integer stars;

    public Integer getVideo_comment_id() {
        return video_comment_id;
    }

    public void setVideo_comment_id(Integer video_comment_id) {
        this.video_comment_id = video_comment_id;
    }

    public Integer getComment_tab_user_id() {
        return comment_tab_user_id;
    }

    public void setComment_tab_user_id(Integer comment_tab_user_id) {
        this.comment_tab_user_id = comment_tab_user_id;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }
}
