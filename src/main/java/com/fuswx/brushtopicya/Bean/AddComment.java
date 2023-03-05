package com.fuswx.brushtopicya.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddComment {
    private Integer id;
    private Integer commentId;
    private Integer userId;
    private String userName;
    private String content;
    private Date commentTime;
    private Integer topCount;
    private Integer stepCount;
    private Integer addCount;
}
