package com.example.test.controller;

import com.example.test.pojo.drugsCheck;
import com.example.test.services.checkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/checkdrugs")
public class CheckController {
    @Autowired
    private checkService checkService;
    @RequestMapping("/selectCk")
    @ResponseBody
    public Map<String,Object> selectCk(drugsCheck drugsCheck){
        List<drugsCheck> list = this.checkService.selectCk(drugsCheck);
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

    @RequestMapping("/deleteCk")
    @ResponseBody
    public Map<String,Object> deleteCk(drugsCheck drugsCheck){
        Map<String, Object> map = new HashMap<>();
        if(this.checkService.deleteCk(drugsCheck)==1) {
            map.put("resultCode", 1);
        }
        else{
            map.put("resultCode", -1);
        }
        return map;
    }

    @RequestMapping("/addCk")
    @ResponseBody
    public Map<String,Object> addCk(drugsCheck drugsCheck){
        Map<String, Object> map = new HashMap<>();
        if(this.checkService.addCk(drugsCheck)==1) {
            map.put("resultCode", 1);
        }
        else{
            map.put("resultCode", -1);
        }
        return map;
    }
    @RequestMapping("/updateCk")
    @ResponseBody
    public Map<String,Object> updateCk(drugsCheck drugsCheck){
        Map<String, Object> map = new HashMap<>();
        if(this.checkService.updateCk(drugsCheck)==1) {
            map.put("resultCode", 1);
        }
        else{
            map.put("resultCode", -1);
        }
        return map;
    }


}
