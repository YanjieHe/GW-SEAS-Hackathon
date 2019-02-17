package com.company.VideoCommunity.controllers;

import com.company.VideoCommunity.models.*;
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

    RecomendationContainer(){
        VideoTab tab = new VideoTab();
        tab.setStart("543");
    }

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
    public Message2 getVideo(@RequestParam(value = "video_url") String link, @RequestParam(value = "user") String user_id) {
        Message2 message2 = new Message2();
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
        temptab.setStart(time);

        videoTabsR.add(temptab);

        tempuser.setUser_id(userID);
        tempuser.setUser_name(" ");

        usersR.add(tempuser);
        message2.setTab(uuid);

        return message2;
    }
    //https://youtu.be/0i7Fr3srkTM?t=2768
    @GetMapping("/getlink")
    @ResponseBody
    public VideoTab returnLink(@Param(value = "uuid") String uuid) {
        Message2 message = new Message2();
        VideoTab tab = new VideoTab();
        if(uuid.equals(""))
        for (int i = 0; i < videoTabsR.size(); i++) {
            if (videoTabsR.get(i).getUuid().equals(uuid)) {
                return videoTabsR.get(i);
            }
        }
        tab.setMid_id("0i7Fr3srkTM");
        tab.setStart("2768");
        Comment2 comments = new Comment2();
        Comment2[] array = new Comment2[2];
        array[0] = comments;
        comments.setText("good");
        comments.setScore(5);
        tab.setComments(array);
        return tab;
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
    public Message2 getComment(@Param(value = "user") String user_id, @Param(value = "comment") String comment) {
        String userid = user_id;
        String user_comment = comment;
        Message2 message2 = new Message2();

        VideoComment videoComment = new VideoComment();
        videoComment.setVideo_comment_id(videoCommentsID++);
        videoComment.setComment_tab_user_id(Integer.valueOf(userid));

        videoCommentsR.add(videoComment);

        return message2;
    }



}
