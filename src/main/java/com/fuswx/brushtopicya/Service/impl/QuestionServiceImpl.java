package com.fuswx.brushtopicya.Service.impl;

import com.fuswx.brushtopicya.Mapper.QuestionMapper;
import com.fuswx.brushtopicya.Service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    private QuestionMapper questionMapper;
}
