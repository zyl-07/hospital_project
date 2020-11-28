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
import java.util.Map;

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

         List<Map<String,Object>> rolelist =this.limitService.selectAllroleByUid(user.getId().toString());
         for(int i=0;i< rolelist.size();i++){
             Map<String, Object> userRole = rolelist.get(i);
             role role = this.limitService.selectRoleByrid( userRole.get("rid").toString());
             if(role!=null) {
                 stringRoleList.add(role.getRname());
             }
             List<Map<String,Object>> rolePermissions = this.limitService.selectAllperByrid(role.getRid().toString());
             for(int j=0;j<rolePermissions.size();j++){
                 Map<String, Object> rolepermission =rolePermissions.get(j);
                 permission permission  = this.limitService.selectPerBypid(rolepermission.get("pid").toString());
                if(permission!=null) {
                    stringPermissionList.add(permission.getPname());
                }
             }
         }
             System.out.println(stringRoleList.toString());

//         for(Map<String,Object> role:rolelist){
//             stringRoleList.add(role.getRname());
//             System.out.println(role.getRname());
//             List<permission> permissionlist = role.getPermissions();
//             for(permission p:permissionlist)
//             {
//                 if(p!=null){
//                     stringPermissionList.add(p.getPname());
//                 }
//             }
//         }

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
