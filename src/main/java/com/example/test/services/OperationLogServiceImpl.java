package com.example.test.services;


import com.example.test.mapper.OperationLogMapper;
import com.example.test.pojo.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**

 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    private OperationLogMapper operationLogMapper;

    @Override
    public List<OperationLog> findAll() {
        return operationLogMapper.findAll();
    }

    @Override
    public int deleteById(String OperationLogId) {
        return operationLogMapper.deleteById(OperationLogId);
    }
}
