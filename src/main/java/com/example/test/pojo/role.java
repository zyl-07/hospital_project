package com.example.test.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer rid;
    String rname;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role"
        ,joinColumns  = @JoinColumn(name = "rid"),
        inverseJoinColumns = @JoinColumn(name = "uid")
    )
    private List<user> users = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true) //orphanRemoval 角色没有这个权限了，
    // 就会把角色对应得权限表信息删除，CascadeType.ALL角色对权限有绝对控制权，角色删除了，权限表信息也会删除
    private List<permission> permissions = new ArrayList<>();
}
