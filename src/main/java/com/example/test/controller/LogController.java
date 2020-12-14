package com.example.test.controller;



import com.example.test.pojo.LoginLog;
import com.example.test.pojo.ManagerSystemLog;
import com.example.test.pojo.OperationLog;
import com.example.test.services.LoginLogService;
import com.example.test.services.ManagerSystemLogService;
import com.example.test.services.OperationLogService;
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
 * 查看和删除日志的controller
 * 包括登录日志，操作日志，系统日志的查看和修改
 *

 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LoginLogService loginLogService;    //登录日志service
    private final org.slf4j.Logger operatorloger = LoggerFactory.getLogger("operationInfo");
    @Autowired
    private ManagerSystemLogService systemLogService;   //系统日志service

    @Autowired
    private OperationLogService operationLogService;    //操作日志service

   // @Autowired
   // private Message message;

    /**
     * 查看登录日志列表
     *
     * @return map的loginlogs中放入查到的日志列表
     */
    @RequestMapping("/loginlog")
    @ResponseBody
    public Map<String,Object> findAllLoginLog() {
        List<LoginLog> loginLogs = loginLogService.findAll();
        Map<String,Object> map = new HashMap<>();
        map.put("resultCode",1);
        map.put("message","请求成功");
        map.put("data",loginLogs);
        return map;
    }

    /**
     * 删除一条登录日志
     *
     * @param loginLogId 待删除的登录日志记录的id号
     * @return message中resultMsg返回删除成功与否
     */
    @RequestMapping("/deleteLoginLog")
    @ResponseBody
    public Map<String,Object> deleteLoginLogById(String loginLogId) {

        int i = loginLogService.deleteById(loginLogId);
        Map<String,Object> map = new HashMap<>();
        if (i == 1) {
//            MDC.clear();
//            MDC.put("userId",uid.toString());
//            operatorloger.info("删除了登录日志"+loginLogId);
//            MDC.clear();
            map.put("resultCode",1);
            map.put("message","删除成功");
            map.put("data",null);
        } else {
            map.put("resultCode",-1);
            map.put("message","删除失败");
            map.put("data",null);

        }
        return map;
    }

    /**
     * 查看系统日志列表
     *
     * @return message中data放入查到的数据
     */
    @RequestMapping("/syslog")
    @ResponseBody
    public Map<String,Object> findAllSysLog() {
        List<ManagerSystemLog> systemLogs = systemLogService.findAll();

        Map<String,Object> map = new HashMap<>();
        map.put("resultCode",1);
        map.put("message","请求成功");
        map.put("data",systemLogs);
        return map;
    }

    /**
     * 删除一条系统日志
     *
     * @param sysLogId 待删除系统日志表中的id
     * @return message中resultMsg返回删除成功与否
     */
    @RequestMapping("/deleteSyslog")
    @ResponseBody
    public Map<String,Object> deleteSysLogById( String sysLogId,HttpSession session) {
        Object uid = session.getAttribute("userId");
        int i = systemLogService.deleteById(sysLogId);
        Map<String,Object> map = new HashMap<>();
        if (i == 1) {
            MDC.clear();
            MDC.put("userId",uid.toString());
            operatorloger.info("删除了系统日志"+sysLogId);
            MDC.clear();
            map.put("resultCode",1);
            map.put("message","删除成功");
            map.put("data",null);
        } else {
            map.put("resultCode",-1);
            map.put("message","删除失败");
            map.put("data",null);
        }
        return map;
    }

    /**
     * 查看操作日志列表
     *
     * @return message中data放入查到的数据
     */
    @RequestMapping("/operlog")
    @ResponseBody
    public Map<String,Object> findAllOperLog() {
        List<OperationLog> all = operationLogService.findAll();
        Map<String,Object> map = new HashMap<>();
        map.put("resultCode",1);
        map.put("message","请求成功");
        map.put("data",all);
        return map;
    }

    /**
     * 删除一条操作日志
     *
     * @param operLogId 待删除操作日志表中的id
     * @return message中resultMsg返回删除成功与否
     */
    @RequestMapping("/deleteOperlog")
    @ResponseBody
    public Map<String,Object> deleteOperLogById(String operLogId) {
        int i = operationLogService.deleteById(operLogId);
        Map<String,Object> map = new HashMap<>();
        if (i == 1) {
            map.put("resultCode",1);
            map.put("message","删除成功");
            map.put("data",null);
        } else {
            map.put("resultCode",-1);
            map.put("message","删除失败");
            map.put("data",null);
        }
        return map;
    }
}
