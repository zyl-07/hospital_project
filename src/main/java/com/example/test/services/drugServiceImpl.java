package com.example.test.services;

import com.example.test.mapper.DrugsMapper;
import com.example.test.pojo.drugs;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
        return 1;
    }

    @Override
    public List<drugs> findAll() {
        return this.drugsMapper.selectAll();
    }

    @Override
    public List<drugs> selectdrug(drugs drug) {
        return this.drugsMapper.selectdrug(drug);
    }

    @Override
    public void deletedrug(drugs drug) {
        this.drugsMapper.deletedrug(drug);
    }

    @Override
    public void updatedrug(drugs drug) {
        this.drugsMapper.updatedrug(drug);
    }

}
