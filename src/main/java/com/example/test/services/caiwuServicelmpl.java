package com.example.test.services;
import com.example.test.mapper.caiwuMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class caiwuServicelmpl implements  caiwuService {
    @Resource
    private caiwuMapper caiwuMapper;


    @Override
    public int addCw(Map<String,Object> map) {
        if (this.caiwuMapper.addcaiwu(map) != 0) {
            return 1;
        } else {
            return -1;
        }
    }
    @Override
    public List<Map<String,Object>> findAll() {
        return this.caiwuMapper.selectAll();
    }
}
