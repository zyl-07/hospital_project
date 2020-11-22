package com.example.test.services;

import com.example.test.mapper.DrugsMapper;
import com.example.test.pojo.drugs;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Service
@Transactional
public class drugServiceImpl implements drugService {
    @Resource
    public DrugsMapper drugsMapper;

    @Override
    public int add(drugs drug) {
        this.drugsMapper.insertdrug(drug);
        if (null != drug.getDno()) {
            return 1;
        } else {
            return -1;
        }

    }

    @Override
    public List<Map<String,Object>> findAll() {

        List<Map<String,Object>> list  = this.drugsMapper.selectAll();
        return list;
    }

    @Override
    public List<drugs> selectdrug(drugs drug) {
        return this.drugsMapper.selectdrug(drug);
    }

    @Override
    public int deletedrug(drugs drug) {
        if (this.drugsMapper.deletedrug(drug) != 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int updatedrug(drugs drug) {
        if (this.drugsMapper.updatedrug(drug) != 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
