package com.example.test.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5util {
    String hashName="MD5";
    public   Object result(String pwd){
        Object result = new SimpleHash(this.hashName,pwd,null,2);
        System.out.println(result);
        return result;
    }
     public static void main(String[] args) {
        MD5util md5util  = new MD5util();
        md5util.result("123");
    }
}
