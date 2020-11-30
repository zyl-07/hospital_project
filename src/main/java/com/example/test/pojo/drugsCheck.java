package com.example.test.pojo;


import javax.persistence.*;

@Entity
@Table(name = "drugscheck")
public class drugsCheck {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键的策略
    Integer id ;
    Integer ckno;//盘点单号
    String ckdate;//盘点日期
    String ckoperator;//操作员
    @ManyToOne(cascade = {CascadeType.MERGE},optional = false)
    @JoinColumn(name = "dno")
    drugs drugs;
    @Transient
    String dno;
    String remark;
    Integer dpnumber;//盘存数量

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCkno() {
        return ckno;
    }

    public void setCkno(Integer ckno) {
        this.ckno = ckno;
    }

    public String getCkdate() {
        return ckdate;
    }

    public void setCkdate(String ckdate) {
        this.ckdate = ckdate;
    }

    public String getCkoperator() {
        return ckoperator;
    }

    public void setCkoperator(String ckoperator) {
        this.ckoperator = ckoperator;
    }

    public com.example.test.pojo.drugs getDrugs() {
        return drugs;
    }

    public void setDrugs(com.example.test.pojo.drugs drugs) {
        this.drugs = drugs;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDpnumber() {
        return dpnumber;
    }

    public void setDpnumber(Integer dpnumber) {
        this.dpnumber = dpnumber;
    }
}
