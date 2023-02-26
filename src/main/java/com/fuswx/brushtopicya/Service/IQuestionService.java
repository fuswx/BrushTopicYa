package com.fuswx.brushtopicya.Service;

import com.fuswx.brushtopicya.Bean.Question;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;

public interface IQuestionService {
    Question getQuestionById(Integer id);

    PageInfo<Question> getAllQuestion(Integer pageNum, Integer pageSize,String sortType);
}
