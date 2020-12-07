package com.example.test.controller;

import com.example.test.pojo.indanhao;
import com.example.test.pojo.put;
import com.example.test.services.putService;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyl
 * 入库接口控制
 */
@Controller
@RequestMapping("/inware")
@CrossOrigin
public class EnterController {
    @Autowired
    private putService putService;
    private final org.slf4j.Logger operatorloger = LoggerFactory.getLogger("operationInfo");
    @RequestMapping("/addEr")
    @ResponseBody
    //增加入库记录
    public Map<String ,Object> addEr(put put, HttpSession session){
        Object uid = session.getAttribute("userId");
        Map<String,Object> map = new HashMap<>();
        if(this.putService.addEr(put)==1)
        {
            MDC.clear();
            MDC.put("userId",uid.toString());
            operatorloger.info("增加了入库信息");
            MDC.clear();
            map.put("resultCode",1);
        }
        else{
            map.put("resultCode",-1);
        }
        return map;
    }

    @RequestMapping("/updateEr")
    @ResponseBody
    //更改入库记录
    public Map<String ,Object> updateEr(put put,HttpSession session){
        Object uid = session.getAttribute("userId");
        Map<String,Object> map = new HashMap<>();
        if(this.putService.updateEr(put)==1)
        {
            MDC.clear();
            MDC.put("userId",uid.toString());
            operatorloger.info("更改了入库信息"+put.getId());
            MDC.clear();
            map.put("resultCode",1);
        }
        else{
            map.put("resultCode",-1);
        }
        return map;
    }


    @RequestMapping("/selectEr")
    @ResponseBody
//  查询入库记录
    public Map<String,Object>  selectEr(put put){
        List<Map<String,Object>> list = this.putService.selectEr(put);
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
    @RequestMapping("/findAll")
    @ResponseBody
//    查询所有入库记录
    public Map<String,Object>  findAll(){
        List<Map<String,Object>> list = this.putService.findAll();
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

    @RequestMapping("/deleteEr")
    @ResponseBody
//    删除入库记录
    public Map<String,Object>  deleteEr(put put,HttpSession session){
        Object uid = session.getAttribute("userId");
        Map<String,Object> map  = new HashMap<>();
        if(this.putService.deleteEr(put)==1){
            MDC.clear();
            MDC.put("userId",uid.toString());
            operatorloger.info("删除入库信息");
            MDC.clear();
            map.put("resultCode", 1);
        }
        else{
            map.put("resultCode", -1);
        }
        return map;
    }
    @RequestMapping("/addsum")
    @ResponseBody
//   提交生成入库单号
    public Map<String,Object>  addsum(indanhao indanhao,HttpSession session){
        Object uid = session.getAttribute("userId");
        Map<String,Object> map  = new HashMap<>();
        if(this.putService.addsum(indanhao)==1){
            MDC.clear();
            MDC.put("userId",uid.toString());
            operatorloger.info("提交了入库单号");
            MDC.clear();
            map.put("resultCode", 1);
        }
        else{
            map.put("resultCode", -1);
        }
        return map;
    }

    @RequestMapping("/findAllsum")
    @ResponseBody
    public Map<String,Object>  findAllsum(){

        List<Map<String,Object>> list = this.putService.findAllsum();
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
