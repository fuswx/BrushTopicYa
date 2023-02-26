package com.fuswx.brushtopicya.Mapper;

import com.fuswx.brushtopicya.Bean.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from users where id=#{gradeId}")
    User getUserById(Integer checkUserId);

}
