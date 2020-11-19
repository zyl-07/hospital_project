package com.example.test.services;

import com.example.test.mapper.outRecord;
import com.example.test.pojo.out;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class outServiceImpl implements outService {
    @Resource
    private outRecord outRecord;
    @Override
    public int addOr(out out) {
       if(this.outRecord.addORecord(out)!=0
        &&this.outRecord.updateDrug(out)!=0)
       {
           return 1;
       }
       else{
           return -1;
       }
    }

    @Override
    public List<out> findAll() {
        return this.outRecord.selectAll();
    }

    @Override
    public List<out> selectOr(out out) {
        return this.outRecord.selectOr(out);
    }
}
