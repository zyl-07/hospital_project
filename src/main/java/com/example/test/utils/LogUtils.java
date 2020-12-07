package com.example.test.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 日志切面，输出请求参数、返回结果、异常信息
 * 在controller返回结果后调用
 *

 */
@Aspect
@Component
public class LogUtils {
    //控制台输出logger
    private Logger logger;

    //系统日志logger，系统出现异常时调用
    private final Logger systemLogger = LoggerFactory.getLogger("systemInfo");

    /**
     * 针对controller中所有public方法进行切面
     */
    @Pointcut("execution(public * com.example.test.controller.*.*(..))")
    public void pointCut() {
    }

    /**
     * 获取请求参数并打印
     *
     * @param joinPoint 连接点
     */
    @Before(value = "pointCut()")
    public void consoleLogParams(JoinPoint joinPoint) {
        this.logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        logger.warn(String.valueOf(args));
    }

    /**
     * 获取返回结果并打印
     *
     * @param message 返回结果
     */
    @AfterReturning(value = "pointCut()", returning = "message")
    public void consoleLogReturnVal(Object message) {
        logger.warn(String.valueOf(message));
    }

    /**
     * 系统异常时打印，并向数据库中系统日志写入一条记录
     *
     * @param joinPoint 连接点
     * @param ex        异常对象
     */
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void consoleLogException(JoinPoint joinPoint, Exception ex) {
        logger.error(ex.toString());
        MDC.clear();
        MDC.put("className", joinPoint.getTarget().getClass().getName());
        MDC.put("methodName", joinPoint.getSignature().getName());
        systemLogger.error(ex.toString());
        MDC.clear();
    }
}
