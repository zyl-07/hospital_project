package com.example.test.controller;

import com.example.test.pojo.ware;
import com.example.test.services.wareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ware")
public class WareController {
    @Autowired
    private wareService wareService;

    @RequestMapping("/addWare")
    @ResponseBody
    public Map<String,Object> addWare(ware ware){
        Map<String,Object> map = new HashMap<>();
        if(this.wareService.addWare(ware)==1){
            map.put("resultCode",1);
        }
        else{
            map.put("resultCode",-1);
        }

        return map;
    }
    @RequestMapping("/deleteWare")
    @ResponseBody
    public Map<String,Object> deleteWare(ware ware){
        Map<String,Object> map = new HashMap<>();
        if(this.wareService.deleteWare(ware)==1){
            map.put("resultCode",1);
        }
        else{
            map.put("resultCode",-1);
        }

        return map;
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(){
        List<ware> list = this.wareService.selectAll();
        Map<String,Object> map = new HashMap<>();
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
