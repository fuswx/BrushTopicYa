package com.fuswx.brushtopicya;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fuswx.brushtopicya.Mapper")
public class BrushTopicYaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrushTopicYaApplication.class, args);
    }

}
