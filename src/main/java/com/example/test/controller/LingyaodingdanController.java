package com.example.test.controller;

import com.example.test.pojo.lingyaodingdan;
import com.example.test.NotFoundException;
import com.example.test.services.lingyaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("ngyaodingdan")
public class LingyaodingdanController {
    /**
     *
     */
    @Autowired
    private lingyaoService lingyaoService;
    @RequestMapping("lectLy")
    @ResponseBody
    public Map<String,Object> selectLy(lingyaodingdan lingyaodingdan){
        List<lingyaodingdan> list = this.lingyaoService.selectLy(lingyaodingdan);
        Map<String,Object> map  = new HashMap<>();
        map.put("resultCode",1);
        map.put("message",list);
        return map;
    }

    @RequestMapping("/deleteLy")
    @ResponseBody
    public Map<String,Object> deleteLy(lingyaodingdan lingyaodingdan){
        this.lingyaoService.deleteLy(lingyaodingdan);
        Map<String,Object> map  = new HashMap<>();
        map.put("resultCode",1);
        return map;
    }

    @RequestMapping("/addLy")
    @ResponseBody
    public Map<String,Object> addLy(lingyaodingdan lingyaodingdan){
        this.lingyaoService.addLy(lingyaodingdan);
        Map<String,Object> map  = new HashMap<>();
        map.put("resultCode",1);
        return map;
    }
    @RequestMapping("/updateLy")
    @ResponseBody
    public Map<String,Object> updateLy(lingyaodingdan lingyaodingdan){
        this.lingyaoService.updateLy(lingyaodingdan);
        Map<String,Object> map  = new HashMap<>();
        map.put("resultCode",1);
        return map;
    }

}
