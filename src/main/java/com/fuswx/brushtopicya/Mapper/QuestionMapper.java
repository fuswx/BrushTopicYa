package com.fuswx.brushtopicya.Mapper;


import com.fuswx.brushtopicya.Bean.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface QuestionMapper {

    //    @Select("select * from questions where id=#{id}")
    @Results({
            @Result(id = true, column = "items", property = "itemsToString"),
            @Result(column = "initAnswer", property = "initAnswerToString")
    })
    Question getQuestionById(Integer id);

    @Results({
            @Result(id = true, column = "items", property = "itemsToString"),
            @Result(column = "initAnswer", property = "initAnswerToString")
    })
    @Select("select * from questions_upload where id=#{id}")
    Question getQuestionUploadById(Integer id);

    @Results({
            @Result(id = true, column = "items", property = "itemsToString"),
            @Result(column = "initAnswer", property = "initAnswerToString")
    })
    @Select("select * from questions_upload where keyCode=#{keyCode}")
    Question getQuestionByKeyCode(String keyCode);

    //    @Select("select * from questions")
    @Results({
            @Result(id = true, column = "items", property = "itemsToString"),
            @Result(column = "initAnswer", property = "initAnswerToString")
    })
    ArrayList<Question> getAllQuestion(String title, ArrayList<Integer> subjectIds, ArrayList<Integer> gradeIds, ArrayList<String> types, ArrayList<Double> degrees);

    //    @Select("select * from questions order by uploadTime DESC")
    @Results({
            @Result(id = true, column = "items", property = "itemsToString"),
            @Result(column = "initAnswer", property = "initAnswerToString")
    })
    ArrayList<Question> getAllQuestionSortByTime(String title, ArrayList<Integer> subjectIds, ArrayList<Integer> gradeIds, ArrayList<String> types, ArrayList<Double> degrees);

    //    @Select("select * from questions order by collectCount DESC")
    @Results({
            @Result(id = true, column = "items", property = "itemsToString"),
            @Result(column = "initAnswer", property = "initAnswerToString")
    })
    ArrayList<Question> getAllQuestionSortByCollect(String title, ArrayList<Integer> subjectIds, ArrayList<Integer> gradeIds, ArrayList<String> types, ArrayList<Double> degrees);

    //    @Select("select * from questions order by watchCount DESC")
    @Results({
            @Result(id = true, column = "items", property = "itemsToString"),
            @Result(column = "initAnswer", property = "initAnswerToString")
    })
    ArrayList<Question> getAllQuestionSortByWatch(String title, ArrayList<Integer> subjectIds, ArrayList<Integer> gradeIds, ArrayList<String> types, ArrayList<Double> degrees);

    //    @Select("select * from questions order by AnswerCount DESC")
    @Results({
            @Result(id = true, column = "items", property = "itemsToString"),
            @Result(column = "initAnswer", property = "initAnswerToString")
    })
    ArrayList<Question> getAllQuestionSortByAnswer(String title, ArrayList<Integer> subjectIds, ArrayList<Integer> gradeIds, ArrayList<String> types, ArrayList<Double> degrees);

    @Insert("insert into questions_upload(keyCode,type,typeName,title,content,items,initAnswer,answer,degree,subjectId,gradeId,uploadUserId,uploadTime,updateTime) " +
            "values (#{keyCode},#{type},#{typeName},#{title},#{content},#{itemsToString},#{initAnswerToString},#{answer},#{degree},#{subjectId},#{gradeId},#{uploadUserId},#{uploadTime},#{updateTime})")
    Boolean setQuestionForm(Question question);
}
