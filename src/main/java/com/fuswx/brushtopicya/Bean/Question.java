package com.fuswx.brushtopicya.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

/**
 * 题目类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    //组件信息
    private Integer id;
    private String keyCode;
    private String type;
    private String typeName;
    private String title;
    //题目内容
    private String content;
    private ArrayList<String> items;
    private String itemsToString;
    private ArrayList<String> initAnswer;
    private String initAnswerToString;
    //题目详细解析
    private String answer;
    private Integer answerCount;
    //收藏人数
    private Integer collectCount;
    //查看人数
    private Integer watchCount;
    //题目平均难度
    private Double degree;
    //题目对应的科目
    private Integer subjectId;
    private String subject;
    //题目对应的年级
    private Integer gradeId;
    private String grade;
    //上传用户
    private Integer uploadUserId;
    private String uploadUserName;
    private String userName;
    //上传时间
    private Date uploadTime;
    //更新时间
    private Date updateTime;
    //审核人id
    private Integer checkUserId;
    private String checkUserName;
    //审核日期
    private Date checkTime;
}
