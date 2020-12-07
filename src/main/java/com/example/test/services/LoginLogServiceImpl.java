package com.example.test.services;


import com.example.test.mapper.LoginLogMapper;
import com.example.test.pojo.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**

 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public int deleteById(String loginLogId) {
        return loginLogMapper.deleteById(loginLogId);
    }

    @Override
    public List<LoginLog> findAll() {
        return loginLogMapper.findAll();
    }
}
