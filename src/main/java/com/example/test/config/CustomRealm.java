package com.example.test.config;

import com.example.test.pojo.permission;
import com.example.test.pojo.role;
import com.example.test.pojo.user;
import com.example.test.services.limitService;
import com.example.test.services.userService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
/*
*自定义Realm
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private limitService limitService;
    @Autowired
    private userService userService;
     @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
         System.out.println("授权 doGetAuthorizationInfo");
         String username = (String)principalCollection.getPrimaryPrincipal();
         user user = userService.selectUserByusername(username);
         List<String> stringRoleList = new ArrayList<>();
         List<String> stringPermissionList = new ArrayList<>();

         List<role> rolelist = user.getRoles();
         for(role role:rolelist){
             stringRoleList.add(role.getRname());
             List<permission> permissionlist = role.getPermissions();
             for(permission p:permissionlist)
             {
                 if(p!=null){
                     stringPermissionList.add(p.getPname());
             }
             }
         }

         SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
         simpleAuthorizationInfo.addRoles(stringRoleList);
         simpleAuthorizationInfo.addStringPermissions(stringPermissionList);
         return simpleAuthorizationInfo;
    }
    /**
     * 用户登录的时候会调用
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证 doGetAuthenticationInfo");
        //从token中获取用户信息 token代表用户输入
        String username = (String) authenticationToken.getPrincipal();
        System.out.println(username);
        user user  = this.userService.selectUserByusername(username);
        //取密码
        String pwd = user.getPassword();
        if(pwd==null||"".equals(pwd)){
            return null;
        }
        return  new SimpleAuthenticationInfo(username,user.getPassword(),this.getClass().getName());
    }
}
