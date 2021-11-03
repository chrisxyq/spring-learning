package com.example.springboottransaction.mapper;

import com.example.springboottransaction.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into user(user_id,username,age) values(#{userId},#{username},#{age})")
    void save(User user);
}
