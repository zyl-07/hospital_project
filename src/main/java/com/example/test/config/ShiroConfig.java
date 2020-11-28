package com.example.test.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        System.out.println("执行 ShiroFilterFactoryBean shiroFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //必须设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //需要登录的接口，如果访问某个接口，需要登录却没登录，则调用此接口
        //这里是前后端分离的模式，如果不是前后端分离则跳转页面
        shiroFilterFactoryBean.setLoginUrl("/pub/need_login");
        //登录成功跳转url,如果前后端分离，则没这个调用
       // shiroFilterFactoryBean.setSuccessUrl("/");
        //没有权限,未授权就会调用此方法，先验证登录-》再验证是否有权限
        shiroFilterFactoryBean.setUnauthorizedUrl("/pub/not_permit");
        //拦截器路径，部分路径无法进行拦截，时有时无，因为使用hashmap，无序的应改为有序的
        Map<String,String> filterChainDefinitmap = new LinkedHashMap<>();
        //退出过滤器
        filterChainDefinitmap.put("/logout","logout");
        //匿名可以访问的，游客模式
        filterChainDefinitmap.put("/admin/**","anon");
        filterChainDefinitmap.put("/**","anon");
        //登录用户才可以访问
//        filterChainDefinitmap.put("/drugs/**","authc");
//        filterChainDefinitmap.put("/limit/**","authc");
//        //管理员角色才可以
//        filterChainDefinitmap.put("/drugs/findAll","perms[admin]");
//        //有编辑权限的才可以访问
//        filterChainDefinitmap.put("/drugs/adddrug","perms[查看药品信息]");
        //全局的,
        //过滤链是顺序执行的，从上到下
        //authc:url需要通过认证才可以访问
        //anon:url可以匿名访问
        //filterChainDefinitmap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitmap);
        return shiroFilterFactoryBean;

    }
     @Bean
     public SecurityManager securityManager(){
            DefaultWebSecurityManager  securityManager = new DefaultWebSecurityManager();
           //如果不是前后端分离，则不需要设置下面的sessionManager
            securityManager.setSessionManager(sessionManager());
            //设置realm（推荐放到最后，不然某些情况会不生效）
            securityManager.setRealm(customRealm());
            return securityManager;
        }
     @Bean
     //自定义realm
    public CustomRealm customRealm(){
        CustomRealm  customRealm = new CustomRealm();
        customRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return customRealm;
     }
     //密码加密规则
     @Bean
     public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置散密算法，这里是MD5
         credentialsMatcher.setHashAlgorithmName("MD5");
         //散列次数
         credentialsMatcher.setHashIterations(2);
         return credentialsMatcher;

     }
    @Bean
    //自定义sessionmanager
     public SessionManager sessionManager(){
        CustomSessionManager customSessionManager = new CustomSessionManager();
        //会话超时时间,默认30分钟
        customSessionManager.setGlobalSessionTimeout(20000);
        return customSessionManager;
    }
}
