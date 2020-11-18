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
@Table(name = "ware")
public class ware {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键的策略
    long wid;
    @Column(nullable = false)
    String wname;

    @OneToMany(mappedBy = "ware",cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
   List<out> out = new ArrayList<>();
    @OneToMany(mappedBy = "ware",cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    List<put> put = new ArrayList<>();


    public long getWid() {
        return wid;
    }

    public void setWid(long wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public List<com.example.test.pojo.out> getOut() {
        return out;
    }

    public void setOut(List<com.example.test.pojo.out> out) {
        this.out = out;
    }

    public List<com.example.test.pojo.put> getPut() {
        return put;
    }

    public void setPut(List<com.example.test.pojo.put> put) {
        this.put = put;
    }
}
