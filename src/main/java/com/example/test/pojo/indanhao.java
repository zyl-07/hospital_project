package com.example.test.pojo;

import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Table(name="indanhao")
public class indanhao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String pno;
    String jiaohuoren;
    String  jizhangren;
    String yanshouren;

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

    public String getJiaohuoren() {
        return jiaohuoren;
    }

    public void setJiaohuoren(String jiaohuoren) {
        this.jiaohuoren = jiaohuoren;
    }

    public String getJizhangren() {
        return jizhangren;
    }

    public void setJizhangren(String jizhangren) {
        this.jizhangren = jizhangren;
    }

    public String getYanshouren() {
        return yanshouren;
    }

    public void setYanshouren(String yanshouren) {
        this.yanshouren = yanshouren;
    }
}
