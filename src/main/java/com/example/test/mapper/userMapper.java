package com.example.test.mapper;

import com.example.test.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface userMapper {
    List<user> checkuser(String username,String password);
    int addUser(user user);
    int updateUser(user user);
    user selectUser(@Param("username") String username);
}
