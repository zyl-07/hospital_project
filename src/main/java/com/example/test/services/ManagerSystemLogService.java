package com.example.test.services;



import com.example.test.pojo.ManagerSystemLog;

import java.util.List;

/**

 */
public interface ManagerSystemLogService {

    List<ManagerSystemLog> findAll();

    int deleteById(String managerSystemLogId);
}
