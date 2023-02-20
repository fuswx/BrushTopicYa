package com.fuswx.brushtopicya.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 学科类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    private Integer id;
    //学科名称
    private String name;
    //学科类别
    private String category;
    //设置人id
    private Integer setUserId;
    //设置时间
    private Date setTime;
}
