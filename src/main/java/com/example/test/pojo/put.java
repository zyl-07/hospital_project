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
@Table(name = "inware")
public class put {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键的策略
    Integer id;//编号
    String pno;
 // @Column(nullable = false)
 // String dname;//药品名称
  //  String dunit;//规格&单位
    Integer idnumber;//入库数量
  //  String dclassify ;//分类
    String idtime;//入库时间
    String idtype;//入库类型
    String iremark;//备注
    String doperator;//操作员
//    String jiaohuoren ;//交货人
//    String yanshouren ;//验收人
//    String jizhangren ;//记账人
    @Transient
    Integer dno;
//    @ManyToOne
//    @JoinColumn(name="wid")
//    ware ware;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST},optional =false)
    @JoinColumn(name = "dno")

     drugs drug;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public Integer getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(Integer idnumber) {
        this.idnumber = idnumber;
    }

    public String getIdtime() {
        return idtime;
    }

    public void setIdtime(String idtime) {
        this.idtime = idtime;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getIremark() {
        return iremark;
    }

    public void setIremark(String iremark) {
        this.iremark = iremark;
    }

    public String getDoperator() {
        return doperator;
    }

    public void setDoperator(String doperator) {
        this.doperator = doperator;
    }

    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }

    public drugs getDrug() {
        return drug;
    }

    public void setDrug(drugs drug) {
        this.drug = drug;
    }
}
