package com.fuswx.brushtopicya.Controller;

import com.fuswx.brushtopicya.Bean.Code;
import com.fuswx.brushtopicya.Bean.Question;
import com.fuswx.brushtopicya.Bean.ResponseData;
import com.fuswx.brushtopicya.Service.IQuestionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/getAllQuestion.do")
    public @ResponseBody ResponseData<PageInfo<Question>> getAllQuestion(@RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                                               @RequestParam(name = "pageSize",defaultValue = "10")Integer pageSize,
                                                                @RequestParam(name = "sortType",defaultValue = "time") String sortType){
        return new ResponseData<>(Code.okk.getCode(), questionService.getAllQuestion(pageNum,pageSize,sortType));
    }
}
