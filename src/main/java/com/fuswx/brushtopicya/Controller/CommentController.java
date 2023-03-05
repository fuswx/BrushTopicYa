package com.fuswx.brushtopicya.Controller;

import com.fuswx.brushtopicya.Bean.AddComment;
import com.fuswx.brushtopicya.Bean.Code;
import com.fuswx.brushtopicya.Bean.Comment;
import com.fuswx.brushtopicya.Bean.ResponseData;
import com.fuswx.brushtopicya.Service.ICommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @GetMapping("/getCommentByQuestionId.do")
    public @ResponseBody ResponseData<PageInfo<Comment>> getCommentByQuestionId(@RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                                                                @RequestParam(name = "pageSize",defaultValue = "10")Integer pageSize,
                                                                                @RequestParam(name = "questionId",required = true)Integer questionId,
                                                                                @RequestParam(name = "userId",required = true)Integer userId){
        return new ResponseData<>(Code.okk.getCode(),commentService.getCommentByQuestionId(pageNum,pageSize,questionId,userId));
    }

    @GetMapping("/getCommentByQuestionIdAndUserId.do")
    public @ResponseBody ResponseData<Comment> getCommentByQuestionIdAndUserId(Integer questionId,Integer userId){
        return new ResponseData<>(Code.okk.getCode(),commentService.getCommentByQuestionIdAndUserId(questionId,userId));
    }

    @GetMapping("/getAddCommentByQuestionId.do")
    public @ResponseBody ResponseData<PageInfo<AddComment>> getAddCommentByQuestionId(@RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                                                                   @RequestParam(name = "pageSize",defaultValue = "5")Integer pageSize,
                                                                                   @RequestParam(name = "commentId",required = true)Integer commentId,
                                                                                   @RequestParam(name = "userId",required = true)Integer userId){
        return new ResponseData<>(Code.okk.getCode(),commentService.getAddCommentByQuestionId(pageNum,pageSize,commentId,userId));
    }

    @GetMapping("/getAddCommentByQuestionIdAndUserId.do")
    public @ResponseBody ResponseData<AddComment> getAddCommentByQuestionIdAndUserId(Integer commentId,Integer userId){
        return new ResponseData<>(Code.okk.getCode(),commentService.getAddCommentByQuestionIdAndUserId(commentId,userId));
    }

}
