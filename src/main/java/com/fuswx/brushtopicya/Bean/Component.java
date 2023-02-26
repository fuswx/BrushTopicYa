package com.fuswx.brushtopicya.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Component {

    private Integer id;
    private String componentName;
    private String title;
    private ArrayList<String> items;
    private String itemsToString;
    private ArrayList<String> initAnswer;
    private String initAnswerToString;
    private String formId;
}
