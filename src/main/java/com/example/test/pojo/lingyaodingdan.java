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
@Table(name ="lingyaodingdan")
public class lingyaodingdan {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键的策略
    Integer lid;//领药订单编号
    //  @Column(nullable = false)
    String lname;//领药药房
    String dname;//药品名称
    float dprice;//单价
    String dclassify;//分类
    String lguige;//规格&danwei
    Integer lnumber;//申请数量
    LocalDateTime ltime;//订单日期
    Integer ljine;//申请金额
    Integer lfayao;//发药数量
    Integer lfyjine;//发药金额
    String lshenqingren;//申请人
    String fuzeren;//负责人
    @ManyToOne(cascade = {CascadeType.MERGE},optional = false)
    @JoinColumn(name = "wid")
    ware ware;

    @ManyToOne(cascade = {CascadeType.MERGE},optional =false)
    @JoinColumn(name = "dno")
    drugs drug;

}
