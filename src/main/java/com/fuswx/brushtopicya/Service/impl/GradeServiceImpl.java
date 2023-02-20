package com.fuswx.brushtopicya.Service.impl;

import com.fuswx.brushtopicya.Bean.Grade;
import com.fuswx.brushtopicya.Mapper.GradeMapper;
import com.fuswx.brushtopicya.Service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class GradeServiceImpl implements IGradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public ArrayList<Grade> findAllGrades() {
        return gradeMapper.findAllGrades();
    }

    @Override
    public ArrayList<Grade> findAllGradeByCategory(String category) {
        return gradeMapper.findAllGradeByCategory(category);
    }
}
