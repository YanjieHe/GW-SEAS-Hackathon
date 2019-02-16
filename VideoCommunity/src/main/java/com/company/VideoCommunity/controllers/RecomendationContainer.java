package com.company.VideoCommunity.controllers;

import com.company.VideoCommunity.models.User;
import com.company.VideoCommunity.models.Video;
import com.company.VideoCommunity.models.VideoComment;
import com.company.VideoCommunity.models.VideoTab;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class RecomendationContainer {

    private Integer videoCommentsID = 0;
    private Integer videoID = 0;
    private Integer userID = 0;
    private Integer tabID = 0;


    List<VideoComment> videoCommentsR = new ArrayList<VideoComment>();
    List<Video> videosR = new ArrayList<Video>();
    List<User> usersR = new ArrayList<User>();
    List<VideoTab> videoTabsR = new ArrayList<VideoTab>();

    public List<VideoComment> getVideoCommentsByVideoID(Integer Id) {
        List<VideoComment> comments = new ArrayList<VideoComment>();
        for (int i = 0; i < videoCommentsR.size(); i++) {
            if (videoCommentsR.get(i).getVideo_id() == Id) {
                comments.add(videoCommentsR.get(i));
            }
        }
        return comments;
    }

    //接收前端的东西
    @PostMapping("savetab")
    @ResponseBody
    public String getVideo(@RequestParam(value = "video_url") String link, @RequestParam(value = "user") String user_id) {
        String userid = user_id;
        String url = link;
        String video_link = url.split("\\*")[0];
        String video_mid = video_link.split("/")[video_link.split("/").length - 1];
        String time = url.split("=")[url.split("=").length - 1];
        String uuid = String.valueOf(UUID.randomUUID());

        Video tempvideo = new Video();
        User tempuser = new User();
        VideoTab temptab = new VideoTab();


        Integer video_link_id = videoID++;

        tempvideo.setVideo_id(video_link_id);
        tempvideo.setVideo_link(video_link);

        videosR.add(tempvideo);

        temptab.setVideo_tab_id(tabID++);
        temptab.setVideo_tab(url);
        temptab.setVideo_url_id(video_link_id);
        temptab.setMid_id(video_mid);
        temptab.setUuid(uuid);
        temptab.setTime(time);

        videoTabsR.add(temptab);

        tempuser.setUser_id(userID);
        tempuser.setUser_name(" ");

        usersR.add(tempuser);

        return uuid;
    }

    //根据video主网址，显示所有这个网址的结果
    public List<VideoComment> recommendation(Integer video_link_id) {
        List<VideoComment> result = new ArrayList<VideoComment>();

        for (int i = 0; i < videoCommentsR.size() - 1; i++) {
            if (videoCommentsR.get(i).getVideo_id() == video_link_id) {
                result.add(videoCommentsR.get(i));
            }
        }
        return result;
    }

    //接收comment
    @PostMapping("comment")
    @ResponseBody
    public boolean getComment(@Param(value = "user") String user_id, @Param(value = "comment") String comment) {
        String userid = user_id;
        String user_comment = comment;

        VideoComment videoComment = new VideoComment();
        videoComment.setVideo_comment_id(videoCommentsID++);
        videoComment.setComment_tab_user_id(Integer.valueOf(userid));

        videoCommentsR.add(videoComment);

        return true;
    }

    @GetMapping("getlink")
    @ResponseBody
    public VideoTab returnLink(@Param(value = "uuid") String uuid) {
        for (int i = 0; i < videoTabsR.size(); i++) {
            if (videoTabsR.get(i).getUuid() == uuid) {
                return videoTabsR.get(i);
            }
        }
        return null;
    }

}
