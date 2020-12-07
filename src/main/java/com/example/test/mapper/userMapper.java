package com.example.test.mapper;

import com.example.test.pojo.user;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cache.decorators.FifoCache;

import java.util.List;
import java.util.Map;

@Mapper
@CacheNamespace(eviction = FifoCache.class,flushInterval = 60000,size = 1024,readWrite = false)
public interface userMapper {
    List<user> checkuser(String username,String password);
    int addUser(user user);
    int updateUser(user user);
    user selectUserByusername(@Param("username") String username);
    user selectUserByUid(@Param("uid") String uid);
    List<Map<String,Object>> selectAllUser();
}
