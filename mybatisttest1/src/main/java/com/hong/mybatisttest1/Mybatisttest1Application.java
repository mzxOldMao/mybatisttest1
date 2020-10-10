package com.hong.mybatisttest1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hong.mybatisttest1.mapper")
public class Mybatisttest1Application {

    public static void main(String[] args) {
        SpringApplication.run(Mybatisttest1Application.class, args);
    }

    

}
