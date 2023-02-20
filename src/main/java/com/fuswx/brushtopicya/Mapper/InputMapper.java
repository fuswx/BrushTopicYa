package com.fuswx.brushtopicya.Mapper;

import com.fuswx.brushtopicya.Bean.Input;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface InputMapper {
    @Select("select * from input_show where id=#{id}")
    Input showOne(Integer id);

    @Select("select * from input_add_update where id=#{id}")
    Input addOne(Integer id);

    @Select("select * from input_init where id=#{id}")
    Input initOne(Integer id);

    @Select("select * from input_show")
    ArrayList<Input> findAll();
}
