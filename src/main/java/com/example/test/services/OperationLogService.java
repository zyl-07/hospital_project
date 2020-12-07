package com.example.test.services;



import com.example.test.pojo.OperationLog;

import java.util.List;

/**

 */
public interface OperationLogService {
    /**
     * 查询所有记录
     * @return 对象列表
     */
    List<OperationLog> findAll();

    /**
     * 删除对应id（主码）的记录
     * @param OperationLogId operation_log表中的主码
     * @return
     */
    int deleteById(String OperationLogId);
}
