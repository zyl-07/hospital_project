package com.example.test.services;


import com.example.test.pojo.LoginLog;

import java.util.List;

/**
 *

 */
public interface LoginLogService {

    List<LoginLog> findAll();

    int deleteById(String loginLogId);
}
