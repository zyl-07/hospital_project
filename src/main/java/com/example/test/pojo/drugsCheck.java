package com.example.test.pojo;


import javax.persistence.*;

@Entity
@Table(name = "drugscheck")
public class drugsCheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ckno;//盘点单号
    String ckdate;//盘点日期
    String ckoperator;//操作员
    @ManyToOne(cascade = {CascadeType.MERGE},optional = false)
    @JoinColumn(name = "dno")
    drugs drugs;
    @Transient
    String dno;
    Integer dpnumber;//盘存数量
}
