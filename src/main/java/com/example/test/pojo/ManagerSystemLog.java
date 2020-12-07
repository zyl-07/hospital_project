package com.example.test.pojo;

/**
 * 系统日志实体类
 *
 * @author liangjin
 * @version V1.0
 * @package cn.edu.sicnu.entity
 * @date 2020/12/1 17:43
 */
public class ManagerSystemLog {
    private Integer managerSystemLogId;
    private String className;
    private String methodName;
    private String logLevel;
    private String message;
    private String createTime;

    public ManagerSystemLog() {
    }

    public ManagerSystemLog(Integer managerSystemLogId, String className, String methodName,
                            String logLevel, String message, String createTime) {
        this.managerSystemLogId = managerSystemLogId;
        this.className = className;
        this.methodName = methodName;
        this.logLevel = logLevel;
        this.message = message;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ManagerSystemLog{" +
                "managerSystemLogId=" + managerSystemLogId +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", logLevel='" + logLevel + '\'' +
                ", message='" + message + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public Integer getManagerSystemLogId() {
        return managerSystemLogId;
    }

    public void setManagerSystemLogId(Integer managerSystemLogId) {
        this.managerSystemLogId = managerSystemLogId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
