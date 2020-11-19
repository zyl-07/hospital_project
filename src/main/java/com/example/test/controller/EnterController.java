package com.example.test.controller;

import com.example.test.pojo.put;
import com.example.test.services.putService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/inware")
public class EnterController {
    @Autowired
    private putService putService;

    @RequestMapping("/addEr")
    @ResponseBody
    public Map<String ,Object> addEr(put put){
        this.putService.addEr(put);
        Map<String,Object> map  = new HashMap<>();
        map.put("resultCode",1);
        return map;
    }
    @RequestMapping("/selectEr")
    @ResponseBody
    public Map<String,Object>  selectEr(put put){
        List<put> list = this.putService.selectEr(put);
        Map<String,Object> map  = new HashMap<>();
        if(null!=list) {

            map.put("message", list);
            map.put("resultCode", 1);
        }
        else{
            map.put("resultCode", -1);
        }
        return map;
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object>  findAll(put put){
        List<put> list = this.putService.findAll();
        Map<String,Object> map  = new HashMap<>();
        if(null!=list) {

            map.put("message", list);
            map.put("resultCode", 1);
        }
        else{
            map.put("resultCode", -1);
        }
        return map;
    }
}
