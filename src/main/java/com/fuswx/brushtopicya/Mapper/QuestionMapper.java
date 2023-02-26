package com.fuswx.brushtopicya.Mapper;


import com.fuswx.brushtopicya.Bean.Question;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface QuestionMapper {

    @Select("select * from questions where id=#{id}")
    @Results({
            @Result(id = true,column = "items",property = "itemsToString"),
            @Result(column = "initAnswer",property = "initAnswerToString")
    })
    Question getQuestionById(Integer id);

    @Select("select * from questions")
    @Results({
            @Result(id = true,column = "items",property = "itemsToString"),
            @Result(column = "initAnswer",property = "initAnswerToString")
    })
    ArrayList<Question> getAllQuestion();

    @Select("select * from questions order by uploadTime DESC")
    @Results({
            @Result(id = true,column = "items",property = "itemsToString"),
            @Result(column = "initAnswer",property = "initAnswerToString")
    })
    ArrayList<Question> getAllQuestionSortByTime();

    @Select("select * from questions order by collectCount DESC")
    @Results({
            @Result(id = true,column = "items",property = "itemsToString"),
            @Result(column = "initAnswer",property = "initAnswerToString")
    })
    ArrayList<Question> getAllQuestionSortByCollect();

    @Select("select * from questions order by watchCount DESC")
    @Results({
            @Result(id = true,column = "items",property = "itemsToString"),
            @Result(column = "initAnswer",property = "initAnswerToString")
    })
    ArrayList<Question> getAllQuestionSortByWatch();

    @Select("select * from questions order by AnswerCount DESC")
    @Results({
            @Result(id = true,column = "items",property = "itemsToString"),
            @Result(column = "initAnswer",property = "initAnswerToString")
    })
    ArrayList<Question> getAllQuestionSortByAnswer();
}
