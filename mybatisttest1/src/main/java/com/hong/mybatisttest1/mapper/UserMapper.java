package com.hong.mybatisttest1.mapper;

import com.hong.mybatisttest1.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface UserMapper {
    @Select("select * from user where user_id = #{id}")
    public User getUserById(int id);

    public List<User> getUser();
}
