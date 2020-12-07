package com.example.test.services;


import com.example.test.mapper.ManagerSystemLogMapper;
import com.example.test.pojo.ManagerSystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**

 */
@Service
public class ManagerSystemLogServiceImpl implements ManagerSystemLogService {

    @Autowired
    ManagerSystemLogMapper managerSystemLogMapper;

    @Override
    public List<ManagerSystemLog> findAll() {
        return managerSystemLogMapper.findAll();
    }

    @Override
    public int deleteById(String managerSystemLogId) {
        return managerSystemLogMapper.deleteById(managerSystemLogId);
    }
}
