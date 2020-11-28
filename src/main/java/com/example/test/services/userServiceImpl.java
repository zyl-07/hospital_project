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

//   查看是否有这个用户通过username，password
    @Override
    public List<user> checkUser(String username,String password) {
        return this.userMapper.checkuser(username,password);
    }

//    添加用户
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

//    更改用户信息
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
//选取用户通过username
    @Override
    public user selectUserByusername(String username) {
        return this.userMapper.selectUserByusername(username);
    }

//    选取用户通过id
    @Override
    public user selectUserByUid(String uid) {
        return this.userMapper.selectUserByUid(uid);
    }

//    选取所以用户
    @Override
    public List<Map<String, Object>> selectAllUser() {
        return this.userMapper.selectAllUser();
    }
}
