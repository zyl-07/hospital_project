package com.example.test.controller;

import com.example.test.pojo.user;
import com.example.test.services.userService;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
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

    private final org.slf4j.Logger operatorloger = LoggerFactory.getLogger("operationInfo");

//增加用户
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
//    更新用户信息
    @RequestMapping("/updateUser")
    @ResponseBody
    public Map<String ,Object> updateUser(user user, HttpSession session){
        Object uid = session.getAttribute("userId");
        Map<String,Object> map  = new HashMap<>();
        if(this.userService.updateUser(user)==1){
            MDC.clear();
            MDC.put("userId",uid.toString());
            operatorloger.info("更改了"+user.getUsername()+"用户信息");
            MDC.clear();
            map.put("resultCode",1);
        }
        else{
            map.put("resultCode",-1);

        }
        return map;
    }
//    选取用户通过uid
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
//   选取所有用户信息
    @RequestMapping("/selectAllUser")
    @ResponseBody
    public Map<String ,Object> selectAllUser(){
        Map<String,Object> map  = new HashMap<>();
        List<Map<String,Object>> list=this.userService.selectAllUser();
        if(null!=list) {
            map.put("resultCode", 1);
            map.put("message", list);
        }
        else{
            map.put("resultCode", -1);
        }
        return  map;
    }
}
