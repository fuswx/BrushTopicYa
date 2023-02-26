package com.fuswx.brushtopicya.Mapper;

import com.fuswx.brushtopicya.Bean.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface GradeMapper {
    //查找所有年级
    @Select("select * from grades")
    ArrayList<Grade> findAllGrades();

    @Select("select * from grades where category=#{category}")
    ArrayList<Grade> findAllGradeByCategory(String category);

    @Select("select * from grades where id=#{gradeId}")
    Grade getGradeById(Integer gradeId);
}
