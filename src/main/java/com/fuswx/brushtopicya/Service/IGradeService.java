package com.fuswx.brushtopicya.Service;

import com.fuswx.brushtopicya.Bean.Grade;

import java.util.ArrayList;

public interface IGradeService {
    //查找所有年级
    ArrayList<Grade> findAllGrades();

    ArrayList<Grade> findAllGradeByCategory(String category);
}
