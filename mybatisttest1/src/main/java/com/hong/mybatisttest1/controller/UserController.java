package com.hong.mybatisttest1.controller;

import com.hong.mybatisttest1.entity.User;
import com.hong.mybatisttest1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    DataSource dataSource;

    @GetMapping("getuser")
    @ResponseBody
    public List<User> getUser(){
        List<User> user = userMapper.getUser();
        System.out.println(dataSource.getClass());
        return user;
    }

    @GetMapping("user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") int id){
        return userMapper.getUserById(id);

    }
}
