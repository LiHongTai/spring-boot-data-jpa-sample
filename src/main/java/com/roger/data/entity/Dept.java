package com.roger.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="dept")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deptno")
    private Integer deptNo;

    //如果属性名和表列名相同，可以不加注解@Column
    @Column(name="dname")
    private String dName;

    @Column(name = "loc")
    private String location;
}
