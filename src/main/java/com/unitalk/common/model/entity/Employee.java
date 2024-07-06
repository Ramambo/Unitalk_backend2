package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "Employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column(name = "employee_no", nullable = false) // 교직원일련번호
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeNo;

    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false) // 직원번호
    private User user;

    @Column(name = "hire_date", nullable = false)   // 입사일
    private LocalDate hireDate;

    @Column(name = "dept_detail")   // 교직원구분
    private String deptDetail;

}
