package com.example.test.services;

import com.example.test.mapper.limitMapper;
import com.example.test.pojo.permission;
import com.example.test.pojo.role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class limitServiceImpl implements  limitService{
    @Resource
    private limitMapper limitMapper;
    @Override
    public int addRole(role role) {
        if(this.limitMapper.addRole(role)!=0)
        {   return 1;}
        else
        {   return -1;}
    }

    @Override
    public int deleteRole(role role) {
        if(this.limitMapper.deleteRole(role)!=0)
        {   return 1;}
        else
        {   return -1;}
    }

    @Override
    public List<role> selectAllOfrole() {
        return this.limitMapper.selectAllOfrole();
    }

    @Override
    public role selectRoleByrid(String rid) {
        return this.limitMapper.selectRoleByrid(rid);
    }

    @Override
    public int addPer(permission permission) {
        if(this.limitMapper.addPer(permission)!=0)
        {   return 1;}
        else
        {   return -1;}
    }

    @Override
    public int deletePer(permission permission) {
        if(this.limitMapper.deletePer(permission)!=0)
        {   return 1;}
        else
        {   return -1;}
    }

    @Override
    public List<permission> selectAllOfper() {
        return this.selectAllOfper();
    }

    @Override
    public permission selectPerBypid(String pid) {
         return this.limitMapper.selectPerBypid(pid);
    }

    @Override
    public permission selectPidByPname(String pname) {
        return this.limitMapper.selectPidByPname(pname);
    }

    @Override
    public List<Map<String, Object>> selectAllroleByUid(String uid) {
        return this.limitMapper.selectAllroleByUid(uid);
    }

    @Override
    public List<Map<String, Object>> selectAllUserRole() {
        return this.limitMapper.selectAllUserRole();
    }

    @Override
    public int addUR(String uid, String rid) {
        if(this.limitMapper.addUR(uid, rid)!=0)
        {   return 1;}
        else
        {   return -1;}
    }

    @Override
    public int delteUR(String uid, String rid) {
        if(this.limitMapper.delteUR(uid, rid)!=0)
        {   return 1;}
        else
        {   return -1;}
    }

    @Override
    public List<Map<String, Object>> selectAllperByrid(String rid) {
        return this.limitMapper.selectAllperByrid(rid);
    }

    @Override
    public int addRp(String rid, String pid) {
        if(this.limitMapper.addRp(rid, pid)!=0)
        {   return 1;}
        else
        {   return -1;}
    }

    @Override
    public int delteRp(String rid, String pid) {
        if(this.limitMapper.delteRp(rid, pid)!=0)
        {   return 1;}
        else
        {   return -1;}
    }

    @Override
    public List<Map<String, Object>> selectUserRolePermission(String uid) {
        return this.limitMapper.selectUserRolePermission(uid);
    }
}
