package com.example.test.services;

import com.example.test.mapper.caigoudingdanMapper;
import com.example.test.pojo.caigoudingdan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class caigoudingdanServiceImpl implements caigoudingdanService {
    @Resource
    private caigoudingdanMapper caigoudingdanMapper;
    @Override
    public List<caigoudingdan> selectCG(caigoudingdan caigoudingdan) {
        return this.caigoudingdanMapper.selectCG(caigoudingdan);
    }

    @Override
    public int deleteCG(caigoudingdan caigoudingdan) {
        if(this.caigoudingdanMapper.deleteCG(caigoudingdan)!=0)
        {   return 1;}
        else
        {   return -1;}
    }

    @Override
    public int updateCG(caigoudingdan caigoudingdan) {
        if (this.caigoudingdanMapper.updateCG(caigoudingdan) != 0) {
            return 1;
        } else {
            return -1;
        }
    }

//    @Override
//    public int  addCk(caigoudingdan caigoudingdan) {
//        if (this.caigoudingdanMapper.addcheCG(caigoudingdan) != 0) {
//            return 1;
//        } else {
//            return -1;
//        }
//    }
}
