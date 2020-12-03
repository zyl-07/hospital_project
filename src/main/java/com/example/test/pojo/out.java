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
    String ono;
 //  @Column(nullable = false)
//    String dname;//药品名称
//    String dunit;//规格&单位
    Integer odnumber;//出库数量
//    String dclassify ;//分类
    String odtime;//出库时间
    String odtype;//出库类型
    String oremark;//备注
    String doperator;//操作员
//    String jiaohuoren ;//交货人
//    String yanshouren ;//验收人
//    String jizhangren ;//记账人

//    @ManyToOne
//    @JoinColumn(name="wid")
//    ware ware;
    @ManyToOne(cascade = {CascadeType.MERGE},optional =false)
    @JoinColumn(name = "dno")
     drugs drug;
    @Transient
    Integer dno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOno() {
        return ono;
    }

    public void setOno(String ono) {
        this.ono = ono;
    }

    public Integer getOdnumber() {
        return odnumber;
    }

    public void setOdnumber(Integer odnumber) {
        this.odnumber = odnumber;
    }

    public String getOdtime() {
        return odtime;
    }

    public void setOdtime(String odtime) {
        this.odtime = odtime;
    }

    public String getOdtype() {
        return odtype;
    }

    public void setOdtype(String odtype) {
        this.odtype = odtype;
    }

    public String getOremark() {
        return oremark;
    }

    public void setOremark(String oremark) {
        this.oremark = oremark;
    }

    public String getDoperator() {
        return doperator;
    }

    public void setDoperator(String doperator) {
        this.doperator = doperator;
    }

    public drugs getDrug() {
        return drug;
    }

    public void setDrug(drugs drug) {
        this.drug = drug;
    }

    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }
}
