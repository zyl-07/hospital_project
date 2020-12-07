package com.example.test.mapper;


import com.example.test.pojo.OperationLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.dao
 * @date 2020/12/3 9:27
 */
@Repository
public interface OperationLogMapper {
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
