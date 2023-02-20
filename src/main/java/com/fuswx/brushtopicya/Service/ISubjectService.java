package com.fuswx.brushtopicya.Service;

import com.fuswx.brushtopicya.Bean.ResponseData;
import com.fuswx.brushtopicya.Bean.Subject;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface ISubjectService {
    //查找所有学科
    ArrayList<Subject> findAllSubjects();
}
