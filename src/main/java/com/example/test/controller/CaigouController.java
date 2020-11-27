package com.example.test.controller;

import com.example.test.pojo.caigou;
import com.example.test.services.caigouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/caigou")
@CrossOrigin
public class CaigouController {

    @Autowired
    private caigouService caigouService;

    @RequestMapping("/addEr")
    @ResponseBody
    public Map<String ,Object> addEr(caigou caigou){
        Map<String,Object> map = new HashMap<>();
        if(this.caigouService.addEr(caigou)==1)
        {
            map.put("resultCode",1);
        }
        else{
            map.put("resultCode",-1);
        }
        return map;
    }
//    @RequestMapping("/selectEr")
//    @ResponseBody
//    public Map<String,Object>  selectEr(caigou caigou){
//        List<caigou> list = this.caigouService.selectEr(caigou);
//        Map<String,Object> map  = new HashMap<>();
//        if(null!=list) {
//
//            map.put("message", list);
//            map.put("resultCode", 1);
//        }
//        else{
//            map.put("resultCode", -1);
//        }
//        return map;
//    }

    @RequestMapping("/findcaigou")
    @ResponseBody
    public Map<String,Object>  findcaigou(caigou caigou){
        List<caigou> list = this.caigouService.findcaigou();
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
