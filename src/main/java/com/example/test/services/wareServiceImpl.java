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
    public int addWare(ware ware) {
        if(this.wareMapper.addWare(ware)!=0)
        {
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public int deleteWare(ware ware) {
        if(this.wareMapper.deleteWare(ware)!=0)
        {
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public List<ware> selectAll() {
        return this.wareMapper.selectAll();
    }


}
