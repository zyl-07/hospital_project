package com.example.test.services;

import com.example.test.mapper.lingyaoMapper;
import com.example.test.pojo.lingyaodingdan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class lingyaoServicelmpl implements lingyaoService{
    @Resource
    private lingyaoMapper lingyaoMapper;

    @Override
    public void add(lingyaodingdan lingyaodingdan) {

    }

    @Override
    public List<Map<String, Object>> findAll() {
        return this.lingyaoMapper.selectAll();
    }

    @Override
    public List<lingyaodingdan> selectLy(lingyaodingdan lingyaodingdan) {
        return this.lingyaoMapper.selectLy(lingyaodingdan);
    }

    @Override
    public int deleteLy(lingyaodingdan lingyaodingdan) {
        if (this.lingyaoMapper.deleteLy(lingyaodingdan)!= 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int updateLy(lingyaodingdan lingyaodingdan) {
        if (this.lingyaoMapper.updateLy(lingyaodingdan)!= 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int addLy(lingyaodingdan lingyaodingdan) {
        if (this.lingyaoMapper.addlingyao(lingyaodingdan)!= 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
