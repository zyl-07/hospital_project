package com.example.test.pojo;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor//无参构造函数
@AllArgsConstructor //全参构造
@ToString
@Entity
@Table(name ="outware")
public class out {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键的策略
   Integer id;//编号
 //  @Column(nullable = false)
//    String dname;//药品名称
//    String dunit;//规格&单位
    Integer odnumber;//出库数量
//    String dclassify ;//分类
    LocalDateTime odtime;//出库时间
    String odtype;//出库类型
    String oremark;//备注
    String doperator;//操作员
    @ManyToOne(cascade = {CascadeType.MERGE},optional = false)
    @JoinColumn(name = "wid")
    ware ware;

    @ManyToOne(cascade = {CascadeType.MERGE},optional =false)
    @JoinColumn(name = "dno")
     drugs drug;

}
