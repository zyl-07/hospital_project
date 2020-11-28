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
//    增加角色
    public int addRole(role role) {
        if(this.limitMapper.addRole(role)!=0)
        {   return 1;}
        else
        {   return -1;}
    }
//删除角色
    @Override
    public int deleteRole(role role) {
        if(this.limitMapper.deleteRole(role)!=0)
        {   return 1;}
        else
        {   return -1;}
    }
//选取所有角色信息
    @Override
    public List<role> selectAllOfrole() {
        return this.limitMapper.selectAllOfrole();
    }
//选取角色通过角色rid
    @Override
    public role selectRoleByrid(String rid) {
        return this.limitMapper.selectRoleByrid(rid);
    }

//    增加权限
    @Override
    public int addPer(permission permission) {
        if(this.limitMapper.addPer(permission)!=0)
        {   return 1;}
        else
        {   return -1;}
    }
//删除权限
    @Override
    public int deletePer(permission permission) {
        if(this.limitMapper.deletePer(permission)!=0)
        {   return 1;}
        else
        {   return -1;}
    }

//  选取所有权限信息
    @Override
    public List<permission> selectAllOfper() {
        return this.selectAllOfper();
    }
//选取权限通过权限的pid
    @Override
    public permission selectPerBypid(String pid) {
         return this.limitMapper.selectPerBypid(pid);
    }
//选取选项pid通过权限名
    @Override
    public permission selectPidByPname(String pname) {
        return this.limitMapper.selectPidByPname(pname);
    }
//选取某用户的所有角色通过用户uid
    @Override
    public List<Map<String, Object>> selectAllroleByUid(String uid) {
        return this.limitMapper.selectAllroleByUid(uid);
    }
//选取用户角色表，返回用户uid,username,角色rid,rname
    @Override
    public List<Map<String, Object>> selectAllUserRole() {
        return this.limitMapper.selectAllUserRole();
    }
//增加用户角色关联表（user_role）信息
    @Override
    public int addUR(String uid, String rid) {
        if(this.limitMapper.addUR(uid, rid)!=0)
        {   return 1;}
        else
        {   return -1;}
    }
//删除用户角色表信息，通过uid,rid
    @Override
    public int delteUR(String uid, String rid) {
        if(this.limitMapper.delteUR(uid, rid)!=0)
        {   return 1;}
        else
        {   return -1;}
    }
//选取某角色所有的权限信息
    @Override
    public List<Map<String, Object>> selectAllperByrid(String rid) {
        return this.limitMapper.selectAllperByrid(rid);
    }
//增加角色权限表信息
    @Override
    public int addRp(String rid, String pid) {
        if(this.limitMapper.addRp(rid, pid)!=0)
        {   return 1;}
        else
        {   return -1;}
    }
//删除角色权限表信息
    @Override
    public int delteRp(String rid, String pid) {
        if(this.limitMapper.delteRp(rid, pid)!=0)
        {   return 1;}
        else
        {   return -1;}
    }
//选取用户-角色-权限信息
    @Override
    public List<Map<String, Object>> selectUserRolePermission(String uid) {
        return this.limitMapper.selectUserRolePermission(uid);
    }
}
