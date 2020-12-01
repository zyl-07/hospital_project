package com.example.test.services;

import com.example.test.mapper.checkMapper;
import com.example.test.mapper.lingyaoMapper;
import com.example.test.pojo.lingyaodingdan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class lingyaoServicelmpl implements lingyaoService{
    @Resource
    private com.example.test.mapper.lingyaoMapper lingyaoMapper;

    @Override
    public void add(lingyaodingdan lingyaodingdan) {

    }

    @Override
    public List<lingyaodingdan> findAll() {
        return null;
    }

    @Override
    public List<lingyaodingdan> selectLy(lingyaodingdan lingyaodingdan) {
        return this.lingyaoMapper.selectLy(lingyaodingdan);
    }

    @Override
    public void deleteLy(lingyaodingdan lingyaodingdan) {
        this.lingyaoMapper.deleteLy(lingyaodingdan);
    }

    @Override
    public void updateLy(lingyaodingdan lingyaodingdan) {
        this.lingyaoMapper.updateLy(lingyaodingdan);
    }

    @Override
    public void addLy(lingyaodingdan lingyaodingdan) {
        this.lingyaoMapper.addlingyao(lingyaodingdan);
    }
}
