package com.fuswx.brushtopicya.Mapper;


import com.fuswx.brushtopicya.Bean.Question;
import org.apache.ibatis.annotations.Select;

public interface QuestionMapper {

    @Select("select * from questions where id=#{id}")
    Question getQuestionById(Integer id);
}
