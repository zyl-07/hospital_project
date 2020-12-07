package com.example.test.mapper;

import com.example.test.pojo.permission;
import com.example.test.pojo.role;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cache.decorators.FifoCache;

import java.util.List;
import java.util.Map;
@Mapper
@CacheNamespace(eviction = FifoCache.class,flushInterval = 60000,size = 1024,readWrite = false)
public interface limitMapper {
    //对role
    int addRole(role role);
    int deleteRole(role role);
    List<role> selectAllOfrole();
    role selectRoleByrid(@Param("rid") String rid);
    //对权限表
    int addPer(permission permission);
    int deletePer(permission permission);
    List<permission> selectAllOfper();
    permission selectPidByPname(@Param("pname") String pname);
    permission selectPerBypid(@Param("pid") String pid);
    //对用户角色表
    List<Map<String,Object>> selectAllroleByUid(@Param("uid") String uid);
    List<Map<String,Object>> selectAllUserRole();
    int addUR(String uid,String rid);
    int updateUR(String uid,String rid);
    int delteUR(String uid,String rid);
    //对角色权限表
    List<Map<String,Object>> selectAllperByrid(@Param("rid") String rid);
    int addRp(String rid,String pid);
    int delteRp(String rid,String pid);
//查询某用户角色权限表
    List<Map<String,Object>> selectUserRolePermission(@Param("uid") String uid);
}
