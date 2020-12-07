package com.example.test.pojo;

import javax.persistence.*;

@Entity
@Table(name = "outdanhao")
public class outdanhao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String ono;
    String jiaohuoren;
    String  jizhangren;
    String  yanshouren;

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
