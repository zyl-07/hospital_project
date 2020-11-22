package com.example.test.services;

import com.example.test.mapper.checkMapper;
import com.example.test.pojo.drugsCheck;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class checkServiceImpl implements  checkService{
    @Resource
    private checkMapper checkMapper;
    @Override
    public  List<Map<String,Object>> selectCk(drugsCheck drugsCheck) {
        return this.checkMapper.selectCr(drugsCheck);
    }

    @Override
    public int deleteCk(drugsCheck drugsCheck) {
        if(this.checkMapper.deleteCk(drugsCheck)!=0)
        {   return 1;}
        else
        {   return -1;}
    }

    @Override
    public int updateCk(drugsCheck drugsCheck) {
        if (this.checkMapper.updateCkanddrug(drugsCheck) != 0) {
            return 1;
        } else {
            return -1;
        }
    }
    @Override
    public int  addCk(Map<String,Object> map) {
        if (this.checkMapper.addcheck(map) != 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
