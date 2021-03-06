package com.example.test.controller;

import com.example.test.pojo.permission;
import com.example.test.pojo.role;
import com.example.test.pojo.user;
import com.example.test.services.limitService;
import com.example.test.services.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author
 *
 */
@Controller
@RequestMapping("limit")
@CrossOrigin
public class LimitController {

    @Autowired
    private limitService limitService;
    private final org.slf4j.Logger operatorloger = LoggerFactory.getLogger("operationInfo");
    @Autowired
    private userService userService;
    @RequestMapping("/findAllPermissionByusername")
    @ResponseBody
//获取某个用户所拥有的权限
    public Map<String,Object>  Permission(String username){


        user user = this.userService.selectUserByusername(username);
        System.out.println(user.getUsername());
        List<Map<String,Object>> userRoles = this.limitService.selectAllroleByUid(user.getId().toString());
        List<permission> permissions = new ArrayList<>();
        for(int i=0;i<userRoles.size();i++){
            Map<String, Object> userRole =userRoles.get(i);
            role role = this.limitService.selectRoleByrid( userRole.get("rid").toString());
            List<Map<String,Object>> rolePermissions = this.limitService.selectAllperByrid(role.getRid().toString());
            for(int j=0;j<rolePermissions.size();j++){
                Map<String, Object> rolepermission =rolePermissions.get(j);
                permission permission  = this.limitService.selectPerBypid(rolepermission.get("pid").toString());
                permissions.add(permission);
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("resultCode",1);
        map.put("message",permissions);
        return map;
    }


    @RequestMapping("/findAllPermissionByRid")
    @ResponseBody
    //获取某个角色所拥有的权限
    public Map<String,Object>  permissionByRid(String rid){
        List<permission> permissions = new ArrayList<>();
        List<Map<String,Object>> rolePermissions = this.limitService.selectAllperByrid(rid);
            for(int j=0;j<rolePermissions.size();j++){
                Map<String, Object> rolepermission =rolePermissions.get(j);
                permission permission  = this.limitService.selectPerBypid(rolepermission.get("pid").toString());
                permissions.add(permission);
            }
        Map<String,Object> map = new HashMap<>();
        map.put("resultCode",1);
        map.put("message",permissions);
        return map;
    }
    //为某角色增加权限
    @RequestMapping("/addPerByUserOfRole")
    @ResponseBody
    public Map<String,Object>  addPermission(String rid,List<String> permissions){
        Map<String,Object> map = new HashMap<>();
            for(int j=0;j<permissions.size();j++) {
                permission permission = this.limitService.selectPidByPname(permissions.get(j));
                if(this.limitService.addRp(rid,this.limitService.selectPidByPname(permission.getPname()).toString())==1){
                    map.put("resultCode",1);
                }
                else{
                    map.put("resultCode",-1);
                }
            }

        return map;
    }
    //为某用户的某角色删除权限
    @RequestMapping("/deletePerByUserOfRole")
    @ResponseBody
    public Map<String,Object>  deletePermission(String username,String rid,List<permission> permissions){
        Map<String,Object> map = new HashMap<>();
        user user = this.userService.selectUserByusername(username);
        role role = this.limitService.selectRoleByrid(rid);
        for(int j=0;j<permissions.size();j++) {
            if(this.limitService.delteRp(role.getRid().toString(),permissions.get(j).getPid().toString())==1){
                map.put("resultCode",1);
            }
            else{
                map.put("resultCode",-1);
            }
        }

        return map;
    }

//  返回所有用户和角色
@RequestMapping("/selectAllUserRole")
@ResponseBody
public Map<String,Object>  selectAllUserRole(){
   // Subject subject =  SecurityUtils.getSubject();
    Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> list = this.limitService.selectAllUserRole();
        if (null != list) {
            map.put("resultCode", 1);
            map.put("message", list);
        } else {
            map.put("resultCode", -1);
        }
    return map;
}
    //返回角色通过rid
    @RequestMapping("/selectRoleByRid")
    @ResponseBody
    public Map<String,Object>  selectRoleByRid(String rid){
        Map<String,Object> map = new HashMap<>();
        role role = this.limitService.selectRoleByrid(rid);
        if(null!=role) {
            map.put("resultCode", 1);
            map.put("message", role);
        }
        else{
            map.put("resultCode", -1);
        }
        return  map;
    }
//返回所有角色
    @RequestMapping("/selectAllOfrole")
    @ResponseBody
    public Map<String,Object>  selectAllOfrole(){
        Map<String,Object> map = new HashMap<>();
        List<role> list = this.limitService.selectAllOfrole();
        if(list.size()!=0) {
            map.put("resultCode", 1);
            map.put("message", list);
        }
        else{
            map.put("resultCode", -1);
        }
        return  map;
    }
    @RequestMapping("/addUr")
    @ResponseBody
//    为某用户增加角色(通过uid,rid)
    public Map<String,Object>  addUr(String uid, String rid, HttpSession session){
        Object id = session.getAttribute("userId");
        Map<String,Object> map = new HashMap<>();
        if(this.limitService.addUR(uid,rid)==1) {
            MDC.clear();
            MDC.put("userId",id.toString());
            operatorloger.info("为用户"+uid+"增加了角色"+rid);
            MDC.clear();
            map.put("resultCode", 1);
        }
        else{
            map.put("resultCode", -1);
        }
        return  map;
    }
    @RequestMapping("/deleteUr")
    @ResponseBody
//    删除用户角色(通过uid,rid)
    public Map<String,Object>  deleteUr(String uid,String rid,HttpSession session){
        Object id = session.getAttribute("userId");
        Map<String,Object> map = new HashMap<>();
        if(this.limitService.delteUR(uid,rid)==1) {
            MDC.clear();
            MDC.put("userId",id.toString());
            operatorloger.info("为用户"+uid+"删除了角色"+rid);
            MDC.clear();
            map.put("resultCode", 1);
        }
        else{
            map.put("resultCode", -1);
        }
        return  map;
    }
    @RequestMapping("/updateUr")
    @ResponseBody
//    更改用户角色(通过uid,rid)
    public Map<String,Object>  updateUr(String uid,String rid,HttpSession session){
       Object id = session.getAttribute("userId");
        Map<String,Object> map = new HashMap<>();
        if(this.limitService.updateUR(uid,rid)==1) {
            MDC.clear();
            MDC.put("userId",id.toString());
            operatorloger.info("为用户"+uid+"更改了角色"+rid);
            MDC.clear();
            map.put("resultCode", 1);
        }
        else{
            map.put("resultCode", -1);
        }
        return  map;
    }
 }
