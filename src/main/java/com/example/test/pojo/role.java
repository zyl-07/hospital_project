package com.example.test.pojo;

import org.apache.ibatis.annotations.Many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer rid;
    @Column(unique=true)
    String rname;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role"
            ,joinColumns  = @JoinColumn(name = "rid"),
            inverseJoinColumns = @JoinColumn(name = "uid")
    )
    private List<user> users = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.PERSIST) //orphanRemoval 角色没有这个权限了，
    // 就会把角色对应得权限表信息删除，CascadeType.ALL角色对权限有绝对控制权，角色删除了，权限表信息也会删除
    @JoinTable(name = "role_permissions"
            ,joinColumns  = @JoinColumn(name = "rid"),
            inverseJoinColumns = @JoinColumn(name = "pid")
    )
    private List<permission> permissions = new ArrayList<>();

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public List<user> getUsers() {
        return users;
    }

    public void setUsers(List<user> users) {
        this.users = users;
    }

    public List<permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<permission> permissions) {
        this.permissions = permissions;
    }
}