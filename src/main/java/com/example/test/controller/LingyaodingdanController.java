package com.example.test.controller;

import com.example.test.pojo.lingyaodingdan;
import com.example.test.NotFoundException;
import com.example.test.services.lingyaoService;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("ngyaodingdan")
@CrossOrigin
public class LingyaodingdanController {
    /**
     *
     */
    @Autowired
    private lingyaoService lingyaoService;
    private final org.slf4j.Logger operatorloger = LoggerFactory.getLogger("operationInfo");
    @RequestMapping("lectLy")
    @ResponseBody
    public Map<String,Object> selectLy(lingyaodingdan lingyaodingdan){
        Map<String, Object> map = new HashMap<>();
        List<lingyaodingdan> list = this.lingyaoService.selectLy(lingyaodingdan);
        if (null != list) {
            map.put("resultCode", 1);
            map.put("message", list);
        } else {
            map.put("resultCode", -1);
        }
        return map;
    }

    @RequestMapping("/deleteLy")
    @ResponseBody
    public Map<String,Object> deleteLy(lingyaodingdan lingyaodingdan, HttpSession session){
        Object uid = session.getAttribute("userId");
        Map<String,Object> map = new HashMap<>();
        if(this.lingyaoService.deleteLy(lingyaodingdan)==1)
        {
            MDC.clear();
            MDC.put("userId",uid.toString());
            operatorloger.info("删除了领药信息");
            MDC.clear();
            map.put("resultCode",1);
        }
        else{
            map.put("resultCode",-1);
        }
        return map;
    }

    @RequestMapping("/addLy")
    @ResponseBody
    public Map<String,Object> addLy(lingyaodingdan lingyaodingdan,HttpSession session){
        Object uid = session.getAttribute("userId");
        Map<String,Object> map = new HashMap<>();
        if(this.lingyaoService.addLy(lingyaodingdan)==1)
        {
            MDC.clear();
            MDC.put("userId",uid.toString());
            operatorloger.info("增加了领药信息");
            MDC.clear();
            map.put("resultCode",1);
        }
        else{
            map.put("resultCode",-1);
        }
        return map;
    }
    @RequestMapping("/updateLy")
    @ResponseBody
    public Map<String,Object> updateLy(lingyaodingdan lingyaodingdan,HttpSession session){
        Object uid = session.getAttribute("userId");
        Map<String,Object> map = new HashMap<>();
        if(this.lingyaoService.updateLy(lingyaodingdan)==1)
        {
            MDC.clear();
            MDC.put("userId",uid.toString());
            operatorloger.info("修改了领药信息");
            MDC.clear();
            map.put("resultCode",1);
        }
        else{
            map.put("resultCode",-1);
        }
        return map;
    }
//    返回所有
@RequestMapping("/findAll")
@ResponseBody

//返回所有领药信息
public Map<String, Object> finAll() {
    Map<String, Object> map = new HashMap<>();
    List<Map<String, Object>> list = this.lingyaoService.findAll();
    if (null != list) {
        map.put("resultCode", 1);
        map.put("message", list);
    } else {
        map.put("resultCode", -1);
    }
    return map;
}

}
