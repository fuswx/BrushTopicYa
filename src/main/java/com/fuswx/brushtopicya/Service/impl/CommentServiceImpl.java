package com.fuswx.brushtopicya.Service.impl;

import com.fuswx.brushtopicya.Bean.AddComment;
import com.fuswx.brushtopicya.Bean.Comment;
import com.fuswx.brushtopicya.Mapper.CommentMapper;
import com.fuswx.brushtopicya.Mapper.UserMapper;
import com.fuswx.brushtopicya.Service.ICommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<Comment> getCommentByQuestionId(Integer pageNum, Integer pageSize, Integer questionId,Integer userId) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<Comment> comments=commentMapper.getCommentByQuestionId(questionId,userId);
        ArrayList<Comment> newComments=new ArrayList<>();
        PageInfo<Comment> pageInfo=new PageInfo<>(comments);
        for (Comment comment:comments) {
            comment.setUserName(userMapper.getUserById(comment.getUserId()).getUserName());
            newComments.add(comment);
        }
        pageInfo.setList(newComments);
        return pageInfo;
    }

    @Override
    public Comment getCommentByQuestionIdAndUserId(Integer questionId, Integer userId) {
        Comment comment=commentMapper.getCommentByQuestionIdAndUserId(questionId,userId);
        if (comment!=null){
            comment.setUserName(userMapper.getUserById(userId).getUserName());
        }
        return comment;
    }

    @Override
    public PageInfo<AddComment> getAddCommentByQuestionId(Integer pageNum, Integer pageSize, Integer commentId, Integer userId) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<AddComment> addComments=commentMapper.getAddCommentByQuestionId(commentId,userId);
        ArrayList<AddComment> newAddComents=new ArrayList<>();
        PageInfo<AddComment> pageInfo=new PageInfo<>(addComments);
        for (AddComment addComment:addComments) {
            addComment.setUserName(userMapper.getUserById(addComment.getUserId()).getUserName());
            newAddComents.add(addComment);
        }
        pageInfo.setList(newAddComents);
        return pageInfo;
    }

    @Override
    public AddComment getAddCommentByQuestionIdAndUserId(Integer commentId, Integer userId) {
        AddComment addComment=commentMapper.getAddCommentByQuestionIdAndUserId(commentId,userId);
        if (addComment!=null){
            addComment.setUserName(userMapper.getUserById(userId).getUserName());
        }
        return addComment;
    }
}
