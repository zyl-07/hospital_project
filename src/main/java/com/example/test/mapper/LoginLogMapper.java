package com.example.test.mapper;


import com.example.test.pojo.LoginLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 登录日志dao接口
 *

 */
@Repository
public interface LoginLogMapper {

    /**
     * 查询所有记录
     *
     * @return 对象列表
     */
    List<LoginLog> findAll();

    /**
     * 删除对应id（主码）的记录
     *
     * @param loginLogId oper_log表中的主码
     * @return 删除的行数
     */
    int deleteById(@Param("loginLogId") String loginLogId);
}
