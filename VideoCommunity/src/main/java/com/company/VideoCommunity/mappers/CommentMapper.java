package com.company.VideoCommunity.mappers;

import com.company.VideoCommunity.models.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import java.util.ArrayList;

@Mapper
public interface CommentMapper {
    @Results({
            @Result(property = "id", column = "commentId"),
            @Result(property = "text", column = "commentText"),
            @Result(property = "score", column = "score")
    })
    @Select("SELECT commentId, commentText, score FROM Comments where videoId = #{videoId}")
    ArrayList<Comment> findByVideoId(@Param("videoId") int videoId);
}
