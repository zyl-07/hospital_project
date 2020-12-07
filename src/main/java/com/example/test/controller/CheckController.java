package com.example.test.controller;

import com.example.test.pojo.drugsCheck;
import com.example.test.services.checkService;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * 药品盘存
 */
@Controller
@RequestMapping("/checkDrugs")
@CrossOrigin
public class CheckController {
    @Autowired
    private checkService checkService;
    private final org.slf4j.Logger operatorloger = LoggerFactory.getLogger("operationInfo");
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
    public Map<String,Object> deleteCk(drugsCheck drugsCheck, HttpSession session){
        Map<String, Object> map = new HashMap<>();
        String uid = (String) session.getAttribute("userId");
        if(this.checkService.deleteCk(drugsCheck)==1) {
            MDC.clear();
            MDC.put("userId",uid);
            operatorloger.info("删除了盘存信息"+drugsCheck.getId());
            MDC.clear();
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
    public Map<String,Object> addCk(drugsCheck drugsCheck,HttpSession session){
        String uid = (String) session.getAttribute("userId");
       // System.out.println(drugsCheck.toString());
        Map<String, Object> maps = new HashMap<>();
        if(this.checkService.addCk(drugsCheck)==1) {
            MDC.clear();
            MDC.put("userId",uid);
            operatorloger.info("增加了盘存信息");
            MDC.clear();
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
    public Map<String,Object> updateCk(drugsCheck drugsCheck,HttpSession session){
        String uid = (String) session.getAttribute("userId");
        Map<String, Object> map = new HashMap<>();
        if(this.checkService.updateCk(drugsCheck)==1) {
            MDC.clear();
            MDC.put("userId",uid);
            operatorloger.info("修改了盘存信息"+drugsCheck.getId());
            MDC.clear();
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