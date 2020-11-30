package com.example.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor//无参构造函数
@AllArgsConstructor //全参构造
@ToString
@Entity
@Table(name = "caigou")
public class caigou {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键的策略
    Integer id ;//编号
    String cgdno ;//采购单号
    Integer ypnumber ;//药品数量
    LocalDateTime cgtime;//采购时间
    String caozuoyuan ;//操作员
    String caigou_beizhu ;//备注
    String caigou_jiaohuoren ;//交货人
    String caigou_yanshouren ;//验收人
    String caigou_jizhangren ;//记账人
    @Transient
    String dname ;
    @Transient
     String dunit ;
    @Transient
   String dclassify ;
    @Transient
    String dno ;
    @ManyToOne(cascade = {CascadeType.MERGE},optional =false)
    @JoinColumn(name = "dno" )
    drugs drugs ;

}
