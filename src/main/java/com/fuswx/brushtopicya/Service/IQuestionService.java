package com.fuswx.brushtopicya.Service;

import com.fuswx.brushtopicya.Bean.Question;
import com.fuswx.brushtopicya.Bean.SearchQuestionConditions;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;

public interface IQuestionService {
    Question getQuestionById(Integer id);

    Question getQuestionUploadById(Integer id);

    PageInfo<Question> getAllQuestion(SearchQuestionConditions conditions);

    Question setQuestionForm(Question question);

    Question getQuestionByKeyCode(String keyCode);
}
