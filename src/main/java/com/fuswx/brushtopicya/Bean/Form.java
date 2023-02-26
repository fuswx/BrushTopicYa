package com.fuswx.brushtopicya.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Form {

    private String id;
    private String title;
    private ArrayList<Component> components;
    private Integer componentNum;
    private Integer uploadUserId;
    private Date uploadTime;
    private Date updateTime;
    private String eg;
}
