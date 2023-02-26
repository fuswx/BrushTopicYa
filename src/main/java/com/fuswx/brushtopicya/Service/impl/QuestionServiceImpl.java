package com.fuswx.brushtopicya.Service.impl;

import com.fuswx.brushtopicya.Bean.Question;
import com.fuswx.brushtopicya.Mapper.GradeMapper;
import com.fuswx.brushtopicya.Mapper.QuestionMapper;
import com.fuswx.brushtopicya.Mapper.SubjectMapper;
import com.fuswx.brushtopicya.Mapper.UserMapper;
import com.fuswx.brushtopicya.Service.IQuestionService;
import com.fuswx.brushtopicya.Utils.Formatter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

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

    @Autowired
    private Formatter formatter;

    @Override
    public Question getQuestionById(Integer id) {
        Question question=questionMapper.getQuestionById(id);
        setQuestion(question);
        return question;
    }

    @Override
    public PageInfo<Question> getAllQuestion(Integer pageNum, Integer pageSize,String sortType) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<Question> questions = switch (sortType) {
            case "time" -> questionMapper.getAllQuestionSortByTime();
            case "collect" -> questionMapper.getAllQuestionSortByCollect();
            case "watch" -> questionMapper.getAllQuestionSortByWatch();
            case "answer" -> questionMapper.getAllQuestionSortByAnswer();
            default -> null;
        };
        ArrayList<Question> newQuestions=new ArrayList<>();
        for (Question question : questions) {
            setQuestion(question);
            newQuestions.add(question);
        }
        PageInfo<Question> pageInfo=new PageInfo<>(questions);
        pageInfo.setList(newQuestions);
        return pageInfo;
    }

    private void setQuestion(Question question) {
        question.setItems(formatter.getInitStringToItems(question.getItemsToString()));
        question.setInitAnswer(formatter.getInitStringToItems(question.getInitAnswerToString()));
        question.setGrade(gradeMapper.getGradeById(question.getGradeId()).getName());
        question.setSubject(subjectMapper.getSubjectById(question.getSubjectId()).getName());
        question.setUserName(userMapper.getUserById(question.getCheckUserId()).getName());
        question.setUploadUserName(userMapper.getUserById(question.getCheckUserId()).getName());
        question.setCheckUserName(userMapper.getUserById(question.getCheckUserId()).getName());
    }
}
