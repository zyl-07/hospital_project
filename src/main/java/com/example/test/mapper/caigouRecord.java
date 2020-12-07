package com.example.test.mapper;

import com.example.test.pojo.caigou;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cache.decorators.FifoCache;

import java.util.List;
import java.util.Map;

@Mapper
@CacheNamespace(eviction = FifoCache.class,flushInterval = 60000,size = 1024,readWrite = false)
public interface caigouRecord {
    int addERecord(caigou caigou);
    List<caigou> selectcaigou();

    List<Map<String, Object>> findcaigou();

    List<Map<String, Object>> findcaigoudingdan();

    int updatecaigou(caigou caigou);

    int deletecaigou(caigou caigou);

    List<caigou> select(caigou caigou);
//    List<caigou> selectEr(caigou caigou);
    List<caigou> selectAll();
}
