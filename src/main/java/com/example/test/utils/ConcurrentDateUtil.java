package com.example.test.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Z_Y_L
 * 生成日期格式辅助类
 */
public class ConcurrentDateUtil {
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
    };

    public static Date parse(String dateStr) throws ParseException {
        return threadLocal.get().parse(dateStr);
    }

    public static String format(Date date) {
        return threadLocal.get().format(date);
    }
}


