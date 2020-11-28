package com.example.test.services;

import com.example.test.mapper.userMapper;
import com.example.test.pojo.user;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public interface userService {
    List<user> checkUser(String username,String password);
    int addUser(user user);
    int updateUser(user user);
    user selectUserByusername(String username);
    user selectUserByUid(String uid);
    List<Map<String,Object>> selectAllUser();
}
