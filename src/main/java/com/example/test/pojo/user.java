package com.example.test.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name  = "user")
public class user {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键的策略
    Integer id ;//用户编号
    String username ;//用户名
    String password ;//密码
    String email;//电子邮箱
    String phone_number;//电话号码
    String invite_code;//邀请码
    String rname;//真实姓名
    String sex;//性别
    String addr;//地址
    String brthday;//出生日期
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "user_role"
           ,joinColumns  = @JoinColumn(name = "uid"),
           inverseJoinColumns = @JoinColumn(name = "rid")
   )
    private List<role> roles = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getInvite_code() {
        return invite_code;
    }

    public void setInvite_code(String invite_code) {
        this.invite_code = invite_code;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getBrthday() {
        return brthday;
    }

    public void setBrthday(String brthday) {
        this.brthday = brthday;
    }

    public List<role> getRoles() {
        return roles;
    }

    public void setRoles(List<role> roles) {
        this.roles = roles;
    }
}
