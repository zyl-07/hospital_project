package com.example.test.services;


import com.example.test.mapper.caigouRecord;
import com.example.test.pojo.caigou;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class caigouServiceImpl implements caigouService {

    @Resource
    private caigouRecord caigouRecord;
    @Override
    public int addEr(caigou caigou) {
        if (this.caigouRecord.addERecord(caigou)!=0)
        {
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public List<caigou> findcaigou() {
        return this.caigouRecord.selectcaigou();
    }

//    @Override
//    public List<caigou> selectEr(caigou caigou) {
//        return this.caigouRecord.selectEr(caigou);
//    }
}
