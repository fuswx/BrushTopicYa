package com.fuswx.brushtopicya.Bean;

import lombok.Data;

public enum Code {
    okk("响应成功",200),error_400("用户出错",400),error_500("服务器出错",500);

    private final String data;
    private final Integer code;
    Code(String data, Integer code) {
        this.data=data;
        this.code=code;
    }

    public Integer getCode(){
        return this.code;
    }
    
    public String getData(){
        return this.data;
    }


}
