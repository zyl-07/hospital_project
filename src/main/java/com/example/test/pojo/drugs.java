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
@Table(name = "drugs")
public class drugs  {
    @Id//主键
    @GeneratedValue//主键的策
    String dno;//药品编号
    @Column(nullable = false)
    String dname ;//药品名称
    String dclassify ;//药品类别
    Integer dnumber ;//药品数量
    String dunit;//规格&单位
    float dprice ;//单价
    String jdtime;//进货日期
    String prodata ;//生产日期
    String duedata ;//有效期
    //我们在上面的代码中给了Student对Course进行级联保存
// （cascade=CascadeType.PERSIST）的权限。
// 此时，若Student实体持有的Course实体在数据库中不存在时，保存该Student时，
// 系统将自动在Course实体对应的数据库中保存这条Course数据。而如果没有这个权限，则无法保存该Course数据。
  //  @OneToMany(mappedBy = "drugs")
  //  List<out> outs   = new ArrayList<>();

    @OneToMany(mappedBy = "drugs")
    List<drugsCheck>  drugsChecks   = new ArrayList<>();

}
