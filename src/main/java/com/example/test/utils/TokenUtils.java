package com.example.test.utils;

import org.apache.commons.lang.StringUtils;
import javax.servlet.http.HttpServletRequest;

/**
 * token工具类
 */
public class TokenUtils {
    /**
     * 获取请求的token
     */
    public static String getRequestToken(HttpServletRequest httpRequest) {

        //从header中获取token
        String token = httpRequest.getHeader("token");
        System.out.println(token);
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(token)) {
            token = httpRequest.getParameter("token");
        }
        return token;
    }
}