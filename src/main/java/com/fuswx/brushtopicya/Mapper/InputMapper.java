package com.fuswx.brushtopicya.Mapper;

import com.fuswx.brushtopicya.Bean.Input;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface InputMapper {

    @Select("select * from input")
    ArrayList<Input> findAll();
}
