package com.company.VideoCommunity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import com.company.VideoCommunity.mappers.CommentMapper;
import com.company.VideoCommunity.models.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public ResponseEntity<Object> recommendComments(@RequestBody int commentId, @RequestBody int videoId) {
        ArrayList<Comment> comments = commentMapper.findByVideoId(videoId);
        int index = -1;
        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            if (comment.id == commentId) {
                index = i;
            }
        }
        // TO DO: comment not found
        Comment comment = comments.get(index);
        comments.remove(index);
        TextSimilarity.sortComments(3, comment, comments);
        HashMap<Integer, Comment> map = new HashMap<Integer, Comment>();
        for (int i = 0; i < comments.size(); i++) {
            map.put(i, comments.get(i));
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
