package com.company.VideoCommunity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.company.VideoCommunity.mappers.CommentMapper;
import com.company.VideoCommunity.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public ResponseEntity<Object> recommendComments(@RequestParam int commentId, @RequestParam int videoId) {
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
        HashMap<String, Object> res = new HashMap<>();
        List<String> commentText = new ArrayList<>(comments.size());
        for(Comment c: comments){
            commentText.add(c.text);
        }
        res.put("comments",commentText);

        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

}
