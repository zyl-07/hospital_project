package com.example.test.controller;

import com.example.test.pojo.user;
import com.example.test.services.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * 用户信息
 */
@Controller
@RequestMapping("/admin")
@CrossOrigin
public class UserController {
    @Autowired
    private userService userService;
    @RequestMapping("/login")
    @ResponseBody
    public Map<String ,Object>  checkUser( String username,
                                          String password){
        //拿到操作主体
        Subject subject =  SecurityUtils.getSubject();
        Map<String,Object> map  = new HashMap<>();
        try{
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
            subject.login(usernamePasswordToken);
            System.out.println("有角色："+subject.hasRole("admin"));
            System.out.println("有权限："+subject.isPermitted("查看药品信息"));

            map.put("resultCode",1);
            map.put("message","登录成功");
            map.put("session_id",subject.getSession().getId());
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("resultCode",-1);
            map.put("message","登录失败");
        }
        return map;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Map<String ,Object> addUser(user user){
        Map<String,Object> map  = new HashMap<>();
        if(this.userService.addUser(user)==1){
            map.put("resultCode",1);
        }
        else{
            map.put("resultCode",-1);

        }
        return map;
    }
    @RequestMapping("/updateUser")
    @ResponseBody
    public Map<String ,Object> updateUser(user user){
        Map<String,Object> map  = new HashMap<>();
        if(this.userService.updateUser(user)==1){
            map.put("resultCode",1);
        }
        else{
            map.put("resultCode",-1);

        }
        return map;
    }
    @RequestMapping("/selectUserByUid")
    @ResponseBody
    public Map<String ,Object> selectUserByUid(String uid){
        Map<String,Object> map  = new HashMap<>();
        user user=this.userService.selectUserByUid(uid);
        if(null!=user){
            map.put("resultCode",1);
            map.put("message",user);
        }
        else{
            map.put("resultCode",-1);

        }
        return map;
    }
}
