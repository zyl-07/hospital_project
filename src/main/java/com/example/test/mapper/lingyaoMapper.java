package com.example.test.mapper;

import com.example.test.pojo.lingyaodingdan;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cache.decorators.FifoCache;

import java.util.List;
import java.util.Map;

@Mapper
@CacheNamespace(eviction = FifoCache.class,flushInterval = 60000,size = 1024,readWrite = false)
public interface lingyaoMapper {
    int addlingyao(lingyaodingdan lingyaodingdan);
    List<lingyaodingdan> selectLy(lingyaodingdan lingyaodingdan);
    int updateLy(lingyaodingdan lingyaodingdan);
    int deleteLy(lingyaodingdan lingyaodingdan);
    List<Map<String,Object>> selectAll();
}