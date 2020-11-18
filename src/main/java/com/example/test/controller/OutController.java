package com.example.test.controller;

import com.example.test.pojo.out;
import com.example.test.services.outService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/outware")
public class OutController {
    @Autowired
    private outService outService;

    @RequestMapping("/addOr")
    @ResponseBody
    public Map<String ,Object> addEr(out out){
        this.outService.addOr(out);
        Map<String,Object> map  = new HashMap<>();
        map.put("resultCode",1);
        return map;
    }
    @RequestMapping("/selectOr")
    @ResponseBody
    public Map<String,Object>  selectOr(out out){
        List<out> list = this.outService.selectOr(out);
        Map<String,Object> map  = new HashMap<>();
        map.put("resultCode",1);
        map.put("message",list);
        return map;
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object>  findAll(out out){
        List<out> list = this.outService.findAll();
        Map<String,Object> map  = new HashMap<>();
        map.put("resultCode",1);
        map.put("message",list);
        return map;
    }
}
