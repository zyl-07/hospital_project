package com.example.test.services;


import com.example.test.mapper.caigouRecord;
import com.example.test.pojo.caigou;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class caigouServiceImpl implements caigouService {

    @Resource
    private caigouRecord caigouRecord;
//    添加采购信息
    @Override
    public int addcaigou(caigou caigou) {
        if (this.caigouRecord.addERecord(caigou)!=0)
        {
            return 1;
        }
        else{
            return -1;
        }
    }
//    按条件查询
    @Override
    public List<caigou> select(caigou caigou) {
        return this.caigouRecord.select(caigou);
    }
//    查看采购订单详细信息
    @Override
    public List<Map<String, Object>> findcaigou() {
        List<Map<String,Object>> list  = this.caigouRecord.findcaigou();
        return list;
    }
//    采购订单

    @Override
    public List<Map<String,Object>> findcaigoudingdan(){
        List<Map<String,Object>> list = this.caigouRecord.findcaigoudingdan();
        return list ;
    }

//    修改

    @Override
    public int updatecaigou(caigou caigou){
        if (this.caigouRecord.updatecaigou(caigou)!=0){
            return 1;
        }else{
            return 0;
        }

    }
//    删除
    public int deletecaigou(caigou caigou){
        if (this.caigouRecord.deletecaigou(caigou)!=0){
            return 1;
        }else {
            return 0;
        }
    }
}

