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
    String cgtime;//采购时间
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
    Integer dno ;
    @ManyToOne(cascade = {CascadeType.MERGE},optional =false)
    @JoinColumn(name = "dno" )
    drugs drugs ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCgdno() {
        return cgdno;
    }

    public void setCgdno(String cgdno) {
        this.cgdno = cgdno;
    }

    public Integer getYpnumber() {
        return ypnumber;
    }

    public void setYpnumber(Integer ypnumber) {
        this.ypnumber = ypnumber;
    }

    public String getCgtime() {
        return cgtime;
    }

    public void setCgtime(String cgtime) {
        this.cgtime = cgtime;
    }

    public String getCaozuoyuan() {
        return caozuoyuan;
    }

    public void setCaozuoyuan(String caozuoyuan) {
        this.caozuoyuan = caozuoyuan;
    }

    public String getCaigou_beizhu() {
        return caigou_beizhu;
    }

    public void setCaigou_beizhu(String caigou_beizhu) {
        this.caigou_beizhu = caigou_beizhu;
    }

    public String getCaigou_jiaohuoren() {
        return caigou_jiaohuoren;
    }

    public void setCaigou_jiaohuoren(String caigou_jiaohuoren) {
        this.caigou_jiaohuoren = caigou_jiaohuoren;
    }

    public String getCaigou_yanshouren() {
        return caigou_yanshouren;
    }

    public void setCaigou_yanshouren(String caigou_yanshouren) {
        this.caigou_yanshouren = caigou_yanshouren;
    }

    public String getCaigou_jizhangren() {
        return caigou_jizhangren;
    }

    public void setCaigou_jizhangren(String caigou_jizhangren) {
        this.caigou_jizhangren = caigou_jizhangren;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDunit() {
        return dunit;
    }

    public void setDunit(String dunit) {
        this.dunit = dunit;
    }

    public String getDclassify() {
        return dclassify;
    }

    public void setDclassify(String dclassify) {
        this.dclassify = dclassify;
    }

    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }

    public com.example.test.pojo.drugs getDrugs() {
        return drugs;
    }

    public void setDrugs(com.example.test.pojo.drugs drugs) {
        this.drugs = drugs;
    }
}
