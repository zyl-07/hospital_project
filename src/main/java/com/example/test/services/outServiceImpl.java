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
    public void addOr(out out) {
        this.outRecord.addORecord(out);
        this.outRecord.updateDrug(out);
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
