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
    String lno;//领药订单号
    String lname;//领药药房
    String dname;//药品名称
    float dprice;//单价
    String dclassify;//分类
    String lguige;//规格&danwei
    Integer lnumber;//申请数量
    String ltime;//订单日期
    Integer ljine;//申请金额
    Integer lfayao;//发药数量
    Integer lfyjine;//发药金额
    String lshenqingren;//申请人
    String fuzeren;//负责人
//    @ManyToOne(cascade = {CascadeType.MERGE},optional = false)
//    @JoinColumn(name = "wid")
//    ware ware;

    @ManyToOne(cascade = {CascadeType.MERGE},optional =false)
    @JoinColumn(name = "dno")
    drugs drug;
    @Transient
    Integer dno;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLno() {
        return lno;
    }

    public void setLno(String lno) {
        this.lno = lno;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public float getDprice() {
        return dprice;
    }

    public void setDprice(float dprice) {
        this.dprice = dprice;
    }

    public String getDclassify() {
        return dclassify;
    }

    public void setDclassify(String dclassify) {
        this.dclassify = dclassify;
    }

    public String getLguige() {
        return lguige;
    }

    public void setLguige(String lguige) {
        this.lguige = lguige;
    }

    public Integer getLnumber() {
        return lnumber;
    }

    public void setLnumber(Integer lnumber) {
        this.lnumber = lnumber;
    }

    public String getLtime() {
        return ltime;
    }

    public void setLtime(String ltime) {
        this.ltime = ltime;
    }

    public Integer getLjine() {
        return ljine;
    }

    public void setLjine(Integer ljine) {
        this.ljine = ljine;
    }

    public Integer getLfayao() {
        return lfayao;
    }

    public void setLfayao(Integer lfayao) {
        this.lfayao = lfayao;
    }

    public Integer getLfyjine() {
        return lfyjine;
    }

    public void setLfyjine(Integer lfyjine) {
        this.lfyjine = lfyjine;
    }

    public String getLshenqingren() {
        return lshenqingren;
    }

    public void setLshenqingren(String lshenqingren) {
        this.lshenqingren = lshenqingren;
    }

    public String getFuzeren() {
        return fuzeren;
    }

    public void setFuzeren(String fuzeren) {
        this.fuzeren = fuzeren;
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
