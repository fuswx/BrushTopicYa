package com.fuswx.brushtopicya.Controller;

import com.fuswx.brushtopicya.Bean.Code;
import com.fuswx.brushtopicya.Bean.Question;
import com.fuswx.brushtopicya.Bean.ResponseData;
import com.fuswx.brushtopicya.Bean.SearchQuestionConditions;
import com.fuswx.brushtopicya.Service.IQuestionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    @GetMapping("/getQuestionById.do")
    public @ResponseBody ResponseData<Question> getQuestionById(Integer id){
        return new ResponseData<>(Code.okk.getCode(), questionService.getQuestionById(id));
    }

    @GetMapping("/getQuestionByKeyCode.do")
    public @ResponseBody ResponseData<Question> getQuestionByKeyCode(String keyCode){
        return new ResponseData<>(Code.okk.getCode(), questionService.getQuestionByKeyCode(keyCode));
    }

    @PostMapping("/getAllQuestion.do")
    public @ResponseBody ResponseData<PageInfo<Question>> getAllQuestion(@RequestBody SearchQuestionConditions conditions){
        return new ResponseData<>(Code.okk.getCode(), questionService.getAllQuestion(conditions));
    }

    @PostMapping("/setQuestionForm.do")
    public @ResponseBody Question setQuestionForm(@RequestBody Question question){
        return questionService.setQuestionForm(question);
    }
}
