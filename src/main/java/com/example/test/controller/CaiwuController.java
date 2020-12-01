package com.example.test.controller;

import com.example.test.services.caiwuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/caiwu")
@CrossOrigin
public class CaiwuController {
    @Autowired
    private caiwuService caiwuService;
    @RequestMapping("/findAll")
    @ResponseBody
    //查询
    public Map<String,Object> selectAll(){
        List<Map<String,Object>> list = this.caiwuService.findAll();
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



    //添加
    @RequestMapping("/addcaiwu")
    @ResponseBody
    public Map<String ,Object> addcaiwu(Map<String,Object> map){
        Map<String,Object> map1 = new HashMap<>();
        if(this.caiwuService.addCw(map)==1)
        {
            map1.put("resultCode",1);
        }
        else{
            map1.put("resultCode",-1);
        }
        return map1;
    }

}
