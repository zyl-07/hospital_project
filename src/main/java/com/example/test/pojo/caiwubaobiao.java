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
@Table(name = "caiwubaobiao")

public class caiwubaobiao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer cwno;//报表号
    String dname;//药品名称
    String dunit;//规格&单位
    float dprice;//单价
    String cwdate;//报表年月
    Integer cqnumber;//初期数量
    Integer rnumber;//入库数量
    Integer cnumber;//出库数量
    float cqjine;//初期金额
    String yk;//盈亏情况
    Integer qmnumber;//期末数量
    float qmjine;//期末金额
    @ManyToOne(cascade = {CascadeType.MERGE},optional = false)
    @JoinColumn(name = "dno")
    drugs drugs;
    @Transient
    String dno;
}
