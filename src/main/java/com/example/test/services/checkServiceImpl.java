package com.example.test.services;

import com.example.test.mapper.checkMapper;
import com.example.test.pojo.drugsCheck;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class checkServiceImpl implements  checkService{
    @Resource
    private checkMapper checkMapper;
    @Override
    public List<drugsCheck> selectCk(drugsCheck drugsCheck) {
        return this.checkMapper.selectCr(drugsCheck);
    }

    @Override
    public void deleteCk(drugsCheck drugsCheck) {
        this.checkMapper.deleteCk(drugsCheck);
    }

    @Override
    public void updateCk(drugsCheck drugsCheck) {
        this.checkMapper.updateCk(drugsCheck);
    }

    @Override
    public void addCk(drugsCheck drugsCheck) {
        this.checkMapper.addcheck(drugsCheck);
    }
}
