package com.fuswx.brushtopicya.Service.impl;

import com.fuswx.brushtopicya.Bean.Question;
import com.fuswx.brushtopicya.Mapper.GradeMapper;
import com.fuswx.brushtopicya.Mapper.QuestionMapper;
import com.fuswx.brushtopicya.Mapper.SubjectMapper;
import com.fuswx.brushtopicya.Mapper.UserMapper;
import com.fuswx.brushtopicya.Service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Question getQuestionById(Integer id) {
        Question question=questionMapper.getQuestionById(id);
        question.setGrade(gradeMapper.getGradeById(question.getGradeId()).getName());
        question.setSubject(subjectMapper.getSubjectById(question.getSubjectId()).getName());
        question.setCheckUserName(userMapper.getUserById(question.getCheckUserId()).getName());
        question.setUserName(userMapper.getUserById(question.getCheckUserId()).getName());
        return question;
    }
}
