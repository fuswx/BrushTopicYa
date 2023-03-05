package com.fuswx.brushtopicya.Service;

import com.fuswx.brushtopicya.Bean.AddComment;
import com.fuswx.brushtopicya.Bean.Comment;
import com.github.pagehelper.PageInfo;

public interface ICommentService {
    PageInfo<Comment> getCommentByQuestionId(Integer pageNum, Integer pageSize, Integer questionId,Integer userId);

    Comment getCommentByQuestionIdAndUserId(Integer questionId, Integer userId);

    PageInfo<AddComment> getAddCommentByQuestionId(Integer pageNum, Integer pageSize, Integer commentId, Integer userId);

    AddComment getAddCommentByQuestionIdAndUserId(Integer questionId, Integer userId);
}
