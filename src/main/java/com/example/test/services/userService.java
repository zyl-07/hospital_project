package com.example.test.services;

import com.example.test.mapper.userMapper;
import com.example.test.pojo.user;

import javax.annotation.Resource;
import java.util.List;

public interface userService {
    List<user> checkUser(String username,String password);
    int addUser(user user);
}
