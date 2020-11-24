package com.example.test.pojo;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyl
 * 权限表
 */
@Entity
@Table(name = "permission")
public class permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer pid;//权限id
    @Column(unique = true)
    String pname;//权限标识
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "role_permissions"
            ,joinColumns  = @JoinColumn(name = "pid"),
            inverseJoinColumns = @JoinColumn(name = "rid")
    )
    private List<role> roles = new ArrayList<>();
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}