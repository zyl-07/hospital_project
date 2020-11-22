package com.example.test.services;

import com.example.test.mapper.enteRecord;
import com.example.test.pojo.put;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class putServiceImpl implements putService {
    @Resource
    private enteRecord enteRecord;
    @Override
    public int addEr(put put) {
        if (this.enteRecord.addERecord(put)!=0&&
        this.enteRecord.updateDrug(put)!=0)
        {
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public  List<Map<String,Object>> findAll() {
        return this.enteRecord.selectAll();
    }

    @Override
    public List<Map<String,Object>>  selectEr(put put) {
        return this.enteRecord.selectEr(put);
    }
}
