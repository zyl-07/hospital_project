package com.example.test.services;

import com.example.test.mapper.enteRecord;
import com.example.test.pojo.indanhao;
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

    @Override
    public int updateEr(put put) {
        if (this.enteRecord.updateER(put)!=0&&
                this.enteRecord.updateDrug(put)!=0)
        {
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public int deleteEr(put put) {
        if (this.enteRecord.deleteEr(put)!=0)
        {
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public int addsum(indanhao indanhao) {
        if (this.enteRecord.addInsum(indanhao)!=0)
        {
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public List<Map<String, Object>> findAllsum() {
        return this.enteRecord.selectAllsum();
    }
}
