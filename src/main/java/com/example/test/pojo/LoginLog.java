package com.example.test.pojo;

import java.io.Serializable;

/**
 * 登录日志实体类
 *
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.entity
 * @date 2020/11/30 17:53
 */
public class LoginLog implements Serializable {
    private Integer loginLogId;
    private String ipAddress;
    private String loginTime;
    private String logLevel;
    private String userId;
    private String message;

    public LoginLog() {
    }

    public LoginLog(Integer loginLogId, String ipAddress, String loginTime,
                    String logLevel, String userId, String message) {
        this.loginLogId = loginLogId;
        this.ipAddress = ipAddress;
        this.loginTime = loginTime;
        this.logLevel = logLevel;
        this.userId = userId;
        this.message = message;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "loginLogId=" + loginLogId +
                ", ipAddress='" + ipAddress + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", logLevel='" + logLevel + '\'' +
                ", userId='" + userId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(Integer loginLogId) {
        this.loginLogId = loginLogId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
