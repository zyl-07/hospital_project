package com.example.test.services;

import com.example.test.mapper.userMapper;
import com.example.test.pojo.user;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class userServiceImpl implements userService{
    @Resource
    private com.example.test.mapper.userMapper userMapper;

    @Override
    public List<user> checkUser(String username,String password) {
        return this.userMapper.checkuser(username,password);
    }
    @Override
    public int addUser(user user){
        if(this.userMapper.addUser(user)!=0)
        {
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public int updateUser(user user) {
        if(this.userMapper.updateUser(user)!=0)
        {
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public user selectUserByusername(String username) {
        return this.userMapper.selectUserByusername(username);
    }

    @Override
    public user selectUserByUid(String uid) {
        return this.userMapper.selectUserByUid(uid);
    }
}
