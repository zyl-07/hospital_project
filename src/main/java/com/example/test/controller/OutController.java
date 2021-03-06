package com.example.test.controller;

import com.example.test.pojo.out;
import com.example.test.pojo.outdanhao;
import com.example.test.pojo.put;
import com.example.test.services.outService;
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

/**
 * @author
 * 出库接口控制
 */
@Controller
@RequestMapping("/outware")
@CrossOrigin
public class OutController {
    @Autowired
    private outService outService;
    private final org.slf4j.Logger operatorloger = LoggerFactory.getLogger("operationInfo");
    @RequestMapping("/addOr")
    @ResponseBody
//    增加出库记录
    public Map<String ,Object> addOr(out out,HttpSession session){
        Object uid = session.getAttribute("userId");
        Map<String,Object> map = new HashMap<>();
        if(this.outService.addOr(out)==1)
        {
            MDC.clear();
            MDC.put("userId",uid.toString());
            operatorloger.info("增加了出库信息");
            MDC.clear();
            map.put("resultCode",1);
        }
        else{
            map.put("resultCode",-1);
        }
        return map;
    }

    @RequestMapping("/updateOr")
    @ResponseBody
    //更改出库记录
    public Map<String ,Object> updateOr(out out,HttpSession session){
        Object uid = session.getAttribute("userId");
        Map<String,Object> map = new HashMap<>();
        if(this.outService.updateOr(out)==1)
        {
            MDC.clear();
            MDC.put("userId",uid.toString());
            operatorloger.info("更改了出库信息");
            MDC.clear();
            map.put("resultCode",1);
        }
        else{
            map.put("resultCode",-1);
        }
        return map;
    }

    @RequestMapping("/selectOr")
    @ResponseBody
//    选择出库记录
    public Map<String,Object>  selectOr(out out){
        List<Map<String,Object>> list = this.outService.selectOr(out);
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
//    返回所有出库记录
    public Map<String,Object>  findAll(out out){

        List<Map<String,Object>> list = this.outService.findAll();
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

    @RequestMapping("/deleteOr")
    @ResponseBody
//    删除出库记录
    public Map<String,Object>  deleteOr(out out,HttpSession session){
        Object uid = session.getAttribute("userId");
        Map<String,Object> map  = new HashMap<>();
        if(this.outService.deleteOr(out)==1){
            MDC.clear();
            MDC.put("userId",uid.toString());
            operatorloger.info("删除了出库信息"+out.getId());
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
//    提交生成出库单号
    public Map<String,Object>  addsum(outdanhao outdanhao){
        Map<String,Object> map  = new HashMap<>();
        if(this.outService.addsum(outdanhao)==1){
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
        List<Map<String,Object>> list = this.outService.findAllsum();
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
