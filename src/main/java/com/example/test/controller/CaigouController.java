package com.example.test.controller;

import com.example.test.pojo.caigou;
import com.example.test.services.caigouService;
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
@RequestMapping("/caigou")
@CrossOrigin
public class CaigouController {

    @Autowired
    private caigouService caigouService;
    private final org.slf4j.Logger operatorloger = LoggerFactory.getLogger("operationInfo");
    //    填写采购订单
    @RequestMapping("/addcaigou")
    @ResponseBody
    public Map<String, Object> addcaigou(caigou caigou, HttpSession session) {
        Object uid =session.getAttribute("userId");
        Map<String, Object> map = new HashMap<>();
        if (this.caigouService.addcaigou(caigou) == 1) {
            MDC.clear();
            MDC.put("userId",uid.toString());
            operatorloger.info("增加了采购信息");
            MDC.clear();
            map.put("resultCode", 1);
        } else {
            map.put("resultCode", -1);
        }
        return map;
    }

    //    查看采购订单详细信息
    @RequestMapping("/findcaigou")
    @ResponseBody
    public Map<String, Object> findcaigou(caigou caigou) {
        List<Map<String, Object>> list = this.caigouService.findcaigou();
        Map<String, Object> map = new HashMap<>();
        if (null != list) {

            map.put("message", list);
            map.put("resultCode", 1);
        } else {
            map.put("resultCode", -1);
        }
        return map;
    }

    //    查看采购订单信息
    @RequestMapping("/findcaigoudingdan")
    @ResponseBody
    public Map<String, Object> findcaigoudingdan(caigou caigou) {
        List<Map<String, Object>> list = this.caigouService.findcaigoudingdan();
        Map<String, Object> map = new HashMap<>();
        if (null != list) {

            map.put("message", list);
            map.put("resultCode", 1);
        } else {
            map.put("resultCode", -1);
        }
        return map;
    }

    //按条件查询（采购单号/时间）
    @RequestMapping(value = "/select")
    @ResponseBody
    public Map<String, Object> selectdrug(caigou caigou) {
        Map<String, Object> map = new HashMap<>();
        List<caigou> list = this.caigouService.select(caigou);
        if (null != list) {
            map.put("resultCode", 1);
            map.put("message", list);
        } else {
            map.put("resultCode", -1);
        }
        return map;
    }

    //删除采购订单信息
    @RequestMapping("/deletecaigou")
    @ResponseBody
    public Map<String, Object> deletecaigou(caigou caigou,HttpSession session) {
        Object uid =session.getAttribute("userId");
        Map<String, Object> map = new HashMap<>();
        if (this.caigouService.deletecaigou(caigou) == 1) {
            MDC.clear();
            MDC.put("userId",uid.toString());
            operatorloger.info("删除了采购信息");
            MDC.clear();
            map.put("resultCode", 1);
        } else {
            map.put("resultCode", -1);
        }
        return map;
    }

    @RequestMapping("/updatecaigou")
    @ResponseBody

    //修改采购订单信息
    public Map<String, Object> updatecaigou(caigou caigou,HttpSession session) {
        Object uid =session.getAttribute("userId");
        Map<String, Object> map = new HashMap<>();
        if (this.caigouService.updatecaigou(caigou) == 1) {
            MDC.clear();
            MDC.put("userId",uid.toString());
            operatorloger.info("修改了采购信息"+caigou.getId());
            MDC.clear();
            map.put("resultCode", 1);
        } else {
            map.put("resultCode", -1);
        }
        return map;
    }


    @RequestMapping("/findAll")
    @ResponseBody

    //返回所有采购信息
    public Map<String, Object> finAll() {
        Map<String, Object> map = new HashMap<>();
        List<caigou> list = this.caigouService.findAll();
        if (null != list) {
            map.put("resultCode", 1);
            map.put("message", list);
        } else {
            map.put("resultCode", -1);
        }
        return map;
    }
}
