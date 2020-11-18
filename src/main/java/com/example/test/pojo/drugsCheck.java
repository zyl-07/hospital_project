package com.example.test.pojo;


import javax.persistence.*;

@Entity
@Table(name = "drugscheck")
public class drugsCheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String ckno;//盘点单号
    String ckdate;//盘点日期
    @ManyToOne(optional = false)
    @JoinColumn(name="wid")
    ware ware;
    String ckoperator;//操作员
    @ManyToOne(cascade = {CascadeType.MERGE},optional = false)
    @JoinColumn(name = "dno")
    drugs drugs;
    Integer dpnumber;//盘存数量
}
