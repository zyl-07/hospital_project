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

/**
 * @author
 * 药品盘存
 */
@Controller
@RequestMapping("/checkDrugs")
public class CheckController {
    @Autowired
    private checkService checkService;
    @RequestMapping("/selectCk")
    @ResponseBody
    //查询
    public Map<String,Object> selectCk(drugsCheck drugsCheck){
        List<Map<String,Object>> list = this.checkService.selectCk(drugsCheck);
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
    //删除
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



    //添加
    @RequestMapping("/addCk")
    @ResponseBody
    public Map<String,Object> addCk(Map<String,Object> map){
        Map<String, Object> maps = new HashMap<>();
        if(this.checkService.addCk(map)==1) {
            maps.put("resultCode", 1);
        }
        else{
            maps.put("resultCode", -1);
        }
        return maps;
    }
    @RequestMapping("/updateCk")
    @ResponseBody

    //修改
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
//以下增加个获取所有盘点记录/findAll
@RequestMapping("/findAll")
@ResponseBody
public Map<String,Object>findAll(){
    List<Map<String,Object>> list = this.checkService.selectAllCk();
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