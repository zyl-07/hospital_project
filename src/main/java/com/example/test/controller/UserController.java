package com.example.test.controller;

import com.example.test.pojo.put;
import com.example.test.pojo.user;
import com.example.test.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String,Object> map  = new HashMap<>();
        List<user> list = this.userService.checkUser(username,password);
        for (user user:list) {
            System.out.println(user.getUsername());
        }
        if(this.userService.checkUser(username,password).size()!=0){
            map.put("resultCode",1);
            return map;
        }
        else{

            map.put("resultCode",-1);
            return map;
        }

    }
}
