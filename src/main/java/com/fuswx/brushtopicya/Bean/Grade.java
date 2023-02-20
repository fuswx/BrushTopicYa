package com.fuswx.brushtopicya.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 年级类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    private Integer id;
    //年纪名称
    private String name;
    //年级类别
    private String category;
    //设置人id
    private Integer setUserId;
    //设置时间
    private Date setTime;
}
