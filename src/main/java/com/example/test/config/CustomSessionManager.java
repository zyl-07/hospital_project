package com.example.test.config;


import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

public class CustomSessionManager extends DefaultWebSessionManager {

    private static final String AUTHORIZATION = "token";
    public CustomSessionManager(){
        super();
    }
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String sessionid  = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        System.out.println(sessionid);
        if(sessionid!=null){
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,
                    ShiroHttpServletRequest.COOKIE_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sessionid);
            //automatically mark it valid here.  If it is invalid, the
            //onUnknownSession method below will be invoked and we'll remove the attribute at that time.
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return sessionid;
        }
        else{
            return super.getSessionId(request,response);
        }
    }

}
