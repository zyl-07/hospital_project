package com.example.test.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor//无参构造函数
@AllArgsConstructor //全参构造
@ToString
@Entity
@Table(name = "caigoudingdan")
public class caigoudingdan {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键的策略
    Integer id ;//编号
//    LocalDateTime cgtime;//采购时间
//    String caigou_jiaohuoren ;//交货人
//    String caigou_yanshouren ;//验收人
//    String caigou_jizhangren ;//记账人
//    String caigou_beizhu ;//备注
 //   String cgdno ;
    @ManyToOne(cascade = {CascadeType.MERGE},optional = false)
    @JoinColumns({
            @JoinColumn(name = "cgdno" , referencedColumnName = "cgdno" ,insertable = false, updatable = false),
            @JoinColumn(name = "cgtime" ,referencedColumnName = "cgtime" ,insertable = false, updatable = false),
            @JoinColumn(name = "caigou_jiaohuoren" , referencedColumnName = "caigou_jiaohuoren" ,insertable = false, updatable = false),
            @JoinColumn(name = "caigou_yanshouren" ,referencedColumnName = "caigou_yanshouren" ,insertable = false, updatable = false),
            @JoinColumn(name = "caigou_jizhangren" , referencedColumnName = "caigou_jizhangren" ,insertable = false, updatable = false),
            @JoinColumn(name = "caigou_beizhu" ,referencedColumnName = "caigou_beizhu" ,insertable = false, updatable = false)
    })
    caigou caigou ;
//    @JoinColumn(name = "cgdno")
//    caigou caigou ;
}
