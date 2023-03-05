package com.fuswx.brushtopicya.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchQuestionConditions {
    private Integer pageNum;
    private Integer pageSize;
    private String sortType;
    private String title;
    private ArrayList<Integer> subjectIds;
    private ArrayList<Integer> gradeIds;
    private ArrayList<String> types;
    private ArrayList<Double> degrees;
}
