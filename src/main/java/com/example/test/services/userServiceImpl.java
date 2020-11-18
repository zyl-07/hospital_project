package com.example.test.services;

import com.example.test.mapper.userMapper;
import com.example.test.pojo.user;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class userServiceImpl implements userService{
    @Resource
    private com.example.test.mapper.userMapper userMapper;

    @Override
    public List<user> checkUser(String username,String password) {
        return this.userMapper.checkuser(username,password);
    }
}
