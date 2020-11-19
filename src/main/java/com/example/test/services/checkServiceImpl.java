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
    public int deleteCk(drugsCheck drugsCheck) {
        this.checkMapper.deleteCk(drugsCheck);
        return 1;
    }

    @Override
    public int updateCk(drugsCheck drugsCheck) {
        this.checkMapper.updateCk(drugsCheck);
        return 1;
    }

    @Override
    public int  addCk(drugsCheck drugsCheck) {
        this.checkMapper.addcheck(drugsCheck);
        return 1;
    }
}
