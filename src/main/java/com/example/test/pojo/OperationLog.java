package com.example.test.pojo;

/**
 * 操作日志实体类
 *
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.entity
 * @date 2020/12/3 9:25
 */
public class OperationLog {
    private Integer operationLogId;
    private String logLevel;
    private String operationTime;
    private String message;
    private String userId;

    @Override
    public String toString() {
        return "OperationLog{" +
                "operationLogId=" + operationLogId +
                ", logLevel='" + logLevel + '\'' +
                ", operationTime='" + operationTime + '\'' +
                ", message='" + message + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public Integer getOperationLogId() {
        return operationLogId;
    }

    public void setOperationLogId(Integer operationLogId) {
        this.operationLogId = operationLogId;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public OperationLog(Integer operationLogId, String logLevel, String operationTime, String message, String userId) {
        this.operationLogId = operationLogId;
        this.logLevel = logLevel;
        this.operationTime = operationTime;
        this.message = message;
        this.userId = userId;
    }

    public OperationLog() {
    }
}
