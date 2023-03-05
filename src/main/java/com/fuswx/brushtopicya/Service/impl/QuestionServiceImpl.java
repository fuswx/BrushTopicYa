package com.fuswx.brushtopicya.Service.impl;

import com.fuswx.brushtopicya.Bean.Question;
import com.fuswx.brushtopicya.Bean.SearchQuestionConditions;
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
        Question question=questionMapper.getQuestionById(id)==null?questionMapper.getQuestionUploadById(id):questionMapper.getQuestionById(id);

        setQuestion(question);
        return question;
    }

    @Override
    public Question getQuestionUploadById(Integer id) {
        Question question=questionMapper.getQuestionUploadById(id);
        setQuestion(question);
        return question;
    }

    @Override
    public PageInfo<Question> getAllQuestion(SearchQuestionConditions conditions) {
        PageHelper.startPage(conditions.getPageNum(),conditions.getPageSize());
        ArrayList<Question> questions = switch (conditions.getSortType()) {
            case "time" -> questionMapper.getAllQuestionSortByTime(conditions.getTitle(),conditions.getSubjectIds(),conditions.getGradeIds(),conditions.getTypes(),conditions.getDegrees());
            case "collect" -> questionMapper.getAllQuestionSortByCollect(conditions.getTitle(),conditions.getSubjectIds(),conditions.getGradeIds(),conditions.getTypes(),conditions.getDegrees());
            case "watch" -> questionMapper.getAllQuestionSortByWatch(conditions.getTitle(),conditions.getSubjectIds(),conditions.getGradeIds(),conditions.getTypes(),conditions.getDegrees());
            case "answer" -> questionMapper.getAllQuestionSortByAnswer(conditions.getTitle(),conditions.getSubjectIds(),conditions.getGradeIds(),conditions.getTypes(),conditions.getDegrees());
            default -> questionMapper.getAllQuestion(conditions.getTitle(),conditions.getSubjectIds(),conditions.getGradeIds(),conditions.getTypes(),conditions.getDegrees());
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

    @Override
    public Question setQuestionForm(Question question) {
        question.setItemsToString(formatter.getInitToString(question.getItems()));
        question.setInitAnswerToString(formatter.getInitToString(question.getInitAnswer()));
        questionMapper.setQuestionForm(question);
        Question questions=questionMapper.getQuestionByKeyCode(question.getKeyCode());
        return questionMapper.getQuestionByKeyCode(question.getKeyCode());
    }

    @Override
    public Question getQuestionByKeyCode(String keyCode) {
        Question question=questionMapper.getQuestionByKeyCode(keyCode);
        question.setItems(formatter.getInitStringToItems(question.getItemsToString()));
        question.setInitAnswer(formatter.getInitStringToItems(question.getInitAnswerToString()));
        return question;
    }

    private void setQuestion(Question question) {
        question.setItems(formatter.getInitStringToItems(question.getItemsToString()));
        question.setInitAnswer(formatter.getInitStringToItems(question.getInitAnswerToString()));
        question.setGrade(gradeMapper.getGradeById(question.getGradeId()).getName());
        question.setSubject(subjectMapper.getSubjectById(question.getSubjectId()).getName());
        question.setUserName(userMapper.getUserById(question.getUploadUserId()).getName());
        question.setUploadUserName(userMapper.getUserById(question.getUploadUserId()).getName());
        if (question.getCheckUserId()!=null){
            question.setCheckUserName(userMapper.getUserById(question.getCheckUserId()).getName());
        }
    }
}
