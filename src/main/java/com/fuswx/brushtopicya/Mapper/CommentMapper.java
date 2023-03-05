package com.fuswx.brushtopicya.Mapper;

import com.fuswx.brushtopicya.Bean.AddComment;
import com.fuswx.brushtopicya.Bean.Comment;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface CommentMapper {

    @Select("select * from comment where questionId=#{questionId} and not userId=#{userId}")
    ArrayList<Comment> getCommentByQuestionId(Integer questionId,Integer userId);

    @Select("select * from comment where questionId=#{questionId} and userId=#{userId}")
    Comment getCommentByQuestionIdAndUserId(Integer questionId, Integer userId);

    @Select("select * from addcomment where commentId=#{commentId} and not userId=#{userId}")
    ArrayList<AddComment> getAddCommentByQuestionId(Integer commentId, Integer userId);

    @Select("select * from addcomment where commentId=#{commentId} and userId=#{userId}")
    AddComment getAddCommentByQuestionIdAndUserId(Integer commentId, Integer userId);
}
