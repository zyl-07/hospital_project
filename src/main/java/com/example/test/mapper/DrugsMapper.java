package com.example.test.mapper;
import com.example.test.pojo.drugs;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cache.decorators.FifoCache;


import java.util.List;
import java.util.Map;

@Mapper
@CacheNamespace(eviction = FifoCache.class,flushInterval = 60000,size = 1024,readWrite = false)
public interface DrugsMapper {
    void insertdrug(drugs drug);
    List<Map<String,Object>> selectAll();
    List<drugs> selectdrug(drugs drug);
    int deletedrug(drugs drug);
    int updatedrug(drugs drug);
}
