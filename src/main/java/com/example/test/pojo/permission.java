package com.example.test.pojo;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

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
    String pname;//权限标识
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rid")
    private role role;
}
