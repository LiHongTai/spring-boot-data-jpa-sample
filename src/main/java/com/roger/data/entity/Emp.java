package com.roger.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "emp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empno;
    private String ename;
    private String job;

    @Column(name = "mgr")
    private String manager;

    @Column(name = "hiredate")
    private LocalDate hireDate;

    @Column(name = "sal")
    private Double salary;
    private Double comm;
    @ManyToOne
    @JoinColumn(name = "deptno")
    private Dept dept;
}
