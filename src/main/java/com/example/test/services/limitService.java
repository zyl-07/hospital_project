package com.example.test.services;

import com.example.test.pojo.permission;
import com.example.test.pojo.role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface limitService {

    int addRole(role role);

    int deleteRole(role role);

    List<role> selectAllOfrole();
    role selectRoleByrid(String rid);

    //对权限表
    int addPer(permission permission);

    int deletePer(permission permission);

    List<permission> selectAllOfper();
    permission selectPerBypid(String pid);
    permission selectPidByPname(String pname);

    //对用户角色表
    List<Map<String, Object>> selectAllroleByUid( String uid);
    List<Map<String, Object>> selectAllUserRole();
    int addUR(String uid, String rid);

    int delteUR(String uid, String rid);

    //对角色权限表
    List<Map<String, Object>> selectAllperByrid( String rid);

    int addRp(String rid, String pid);

    int delteRp(String rid, String pid);


    //获取用户角色权限信息通过用户id
    List<Map<String, Object>> selectUserRolePermission( String uid);
}