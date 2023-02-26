package com.fuswx.brushtopicya.Mapper;

import com.fuswx.brushtopicya.Bean.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface SubjectMapper {
    //查找所有学科
    @Select("select * from subjects")
    ArrayList<Subject> findAllSubjects();

    @Select("select * from subjects where id=#{gradeId}")
    Subject getSubjectById(Integer subjectId);
}
