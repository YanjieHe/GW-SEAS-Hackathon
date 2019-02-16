package com.company.VideoCommunity.models;

import java.util.UUID;


public class VideoTab {

    private Integer video_tab_id;

    private String video_tab;

    private Integer video_url_id;

    private String mid_id;

    private String uuid;

    private String time;

    private String video_link;

    public String getVideo_link() {
        return video_link;
    }

    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }

    public Integer getVideo_tab_id() {
        return video_tab_id;
    }

    public void setVideo_tab_id(Integer video_tab_id) {
        this.video_tab_id = video_tab_id;
    }

    public String getVideo_tab() {
        return video_tab;
    }

    public void setVideo_tab(String video_tab) {
        this.video_tab = video_tab;
    }

    public Integer getVideo_url_id() {
        return video_url_id;
    }

    public void setVideo_url_id(Integer video_url_id) {
        this.video_url_id = video_url_id;
    }

    public String getMid_id() {
        return mid_id;
    }

    public void setMid_id(String mid_id) {
        this.mid_id = mid_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
