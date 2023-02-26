package com.fuswx.brushtopicya.Utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class Formatter {
    public String getInitToString(ArrayList<String> items){
        StringBuilder itemsToString= new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            if (i==0){
                itemsToString.append(items.get(i));
            }else {
                itemsToString.append("··").append(items.get(i));
            }
        }
        return itemsToString.toString();
    }

    public ArrayList<String> getInitStringToItems(String initString){
        String[] items=initString.split("··");
        return new ArrayList<>(Arrays.asList(items));
    }
}
