package com.example.test.services;

import com.example.test.mapper.wareMapper;
import com.example.test.pojo.ware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class wareServiceImpl implements wareService {
    @Resource
    private wareMapper wareMapper;
    @Override
    public void addWare(ware ware) {
        this.wareMapper.addWare(ware);
    }

    @Override
    public void deleteWare(ware ware) {
        this.wareMapper.deleteWare(ware);
    }

    @Override
    public List<ware> selectAll() {
        return this.wareMapper.selectAll();
    }


}
