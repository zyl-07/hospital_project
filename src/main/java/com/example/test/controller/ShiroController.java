package com.example.test.controller;

import com.example.test.pojo.user;
import com.example.test.services.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.MDC;
@Controller
@RequestMapping("/pub")
@CrossOrigin
public class ShiroController {
    @Autowired
    private com.example.test.services.userService userService;

    private final org.slf4j.Logger loginloger = LoggerFactory.getLogger("loginInfo");
    @RequestMapping("/not_permit")
    @ResponseBody
    public Map<String,Object> notpermit(){
        Map<String,Object> map = new HashMap<>();
        map.put("data","提示：没有权限");
        map.put("code",-3);
        return map;
    }

    @RequestMapping("/need_login")
    @ResponseBody
    public Map<String,Object> needlogin(){
        Map<String,Object> map = new HashMap<>();
        map.put("data","提示：请先登录");
        map.put("code",-2);
        return map;
    }

    //   用户登录
    @RequestMapping("/login")
    @ResponseBody
    public Map<String ,Object>  checkUser(HttpServletRequest request, HttpServletResponse response){
        //拿到操作主体
        Subject subject =  SecurityUtils.getSubject();
        Map<String,Object> map  = new HashMap<>();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            subject.login(token);
            user user = userService.selectUserByusername(username);
            map.put("resultCode",1);
            map.put("message","登录成功");
            map.put("token",subject.getSession().getId());

            HttpSession session = request.getSession();
            session.setAttribute("userId",user.getUsername());
            MDC.clear();
            MDC.put("userId",user.getUsername());
            MDC.put("ipAddress",request.getHeader("Origin"));
            loginloger.info("登录");
            MDC.clear();
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("resultCode",-1);
            map.put("message","登录失败");
        }
        return map;
    }
    @RequestMapping("/logout")
    @ResponseBody
    public Map<String ,Object> logout(){
        Subject subject = SecurityUtils.getSubject();
        Map<String,Object> map  = new HashMap<>();
            subject.logout();
            map.put("resultCode",1);
            map.put("message","登出成功");
            return map;
    }
}
