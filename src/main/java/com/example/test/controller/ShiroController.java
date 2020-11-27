package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pub")
public class ShiroController {


    @RequestMapping("/not_permit")
    @ResponseBody
    public Map<String,Object> notpermit(){
        Map<String,Object> map = new HashMap<>();
        map.put("data","提示：没有权限");
        map.put("code",-3);
        return map;
    }

    @RequestMapping("/need_login")
    @ResponseBody
    public Map<String,Object> needlogin(){
        Map<String,Object> map = new HashMap<>();
        map.put("data","提示：请先登录");
        map.put("code",-2);
        return map;
    }
    @RequestMapping("/index")
    @ResponseBody
    public Map<String,Object> index(){
        Map<String,Object> map = new HashMap<>();
        map.put("data","提示：ok");
        map.put("code",1);
        return map;
    }
}
