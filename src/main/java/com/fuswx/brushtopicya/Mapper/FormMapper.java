package com.fuswx.brushtopicya.Mapper;

import com.fuswx.brushtopicya.Bean.Component;
import com.fuswx.brushtopicya.Bean.Form;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface FormMapper {
    @Insert("insert into forms values(#{id},#{title},#{componentNum},#{uploadUserId},#{uploadTime},#{updateTime},#{eg})")
    Boolean saveForm(Form form);

    @Insert("insert into component values(null,#{componentName},#{title},#{itemsToString},#{initAnswerToString},#{formId})")
    Boolean saveComponent(Component component);

    @Select("select * from forms where id=#{formId}")
    Form getFormById(String formId);


    @Select("select * from component where formId=#{formId}")
    @Results({
            @Result(id = true,column = "items",property = "itemsToString"),
            @Result(column = "initAnswer",property = "initAnswerToString")
    })
    ArrayList<Component> getAllComponentsByFormId(String formId);

    @Select("select * from forms order by uploadTime ASC")
    ArrayList<Form> findAllForm();

    @Delete("delete from forms where id=#{id}")
    void deleteFormById(String id);

    @Delete("delete from component where formId=#{formId}")
    void deleteComponentByFormId(String formId);
}
