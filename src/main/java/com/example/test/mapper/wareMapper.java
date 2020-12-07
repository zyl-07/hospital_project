package com.example.test.mapper;

import com.example.test.pojo.ware;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cache.decorators.FifoCache;

import java.util.List;
@Mapper
@CacheNamespace(eviction = FifoCache.class,flushInterval = 60000,size = 1024,readWrite = false)
public interface wareMapper {
    int addWare(ware ware);
    List<ware> selectAll();
    int deleteWare(ware ware);
}
