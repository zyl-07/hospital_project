package com.example.test.controller;


import com.example.test.pojo.caigoudingdan;
import com.example.test.services.caigoudingdanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/caidoudingdan")
@CrossOrigin
public class CaigoudingdanController {
    @Autowired
    private caigoudingdanService caigoudingdanService ;
    @RequestMapping("/selectCG")
    @ResponseBody
    //查询
    public Map<String,Object> selectCG(caigoudingdan caigoudingdan){
        List<caigoudingdan> list = this.caigoudingdanService.selectCG(caigoudingdan);
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

    @RequestMapping("/deleteCG")
    @ResponseBody
    //删除
    public Map<String,Object> deleteCG(caigoudingdan caigoudingdan){
        Map<String, Object> map = new HashMap<>();
        if(this.caigoudingdanService.deleteCG(caigoudingdan)==1) {
            map.put("resultCode", 1);
        }
        else{
            map.put("resultCode", -1);
        }
        return map;
    }

//    @RequestMapping("/addCG")
//    @ResponseBody
//
//    //添加
//    public Map<String,Object> addCG(caigoudingdan caigoudingdan){
//        Map<String, Object> map = new HashMap<>();
//        if(this.caigoudingdanService.addCG(caigoudingdan)==1) {
//            map.put("resultCode", 1);
//        }
//        else{
//            map.put("resultCode", -1);
//        }
//        return map;
//    }
    @RequestMapping("/updateCG")
    @ResponseBody

    //修改
    public Map<String,Object> updateCG(caigoudingdan caigoudingdan){
        Map<String, Object> map = new HashMap<>();
        if(this.caigoudingdanService.updateCG(caigoudingdan)==1) {
            map.put("resultCode", 1);
        }
        else{
            map.put("resultCode", -1);
        }
        return map;
    }


}
