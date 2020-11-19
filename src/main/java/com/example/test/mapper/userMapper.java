package com.example.test.mapper;

import com.example.test.pojo.user;

import java.util.List;

public interface userMapper {
    List<user> checkuser(String username,String password);
    int addUser(user user);
}
