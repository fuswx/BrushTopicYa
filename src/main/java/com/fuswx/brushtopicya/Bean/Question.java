package com.fuswx.brushtopicya.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 题目类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Integer id;
    //题目内容
    private String content;
    //题目答案
    private String answer;
    //题目难度
    private Integer degree;
    //题目对应的科目
    private Integer subjectId;
    //题目对应的年级
    private Integer gradeId;
    //上传用户
    private Integer uploadUserId;
    //上传时间
    private Date uploadTime;
}
