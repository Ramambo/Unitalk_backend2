package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Employees")
@Getter
@Setter
@NoArgsConstructor
//교직원정보 Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_no", nullable = false)
    private Long employeeNo; //교직원 일련번호, PK

    @OneToOne
    @JoinColumn(name = "employee_id", unique = true, nullable = false, referencedColumnName = "user_id")
    private User user; //교직원 ID(직번)
    
    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate; //입사연월일

    @Column(name = "dept_detail", nullable = false)
    private String deptDetail; //교직원구분

    @Builder
    private Employee(User user, LocalDate hireDate, String deptDetail) {
        this.user = user;
        this.hireDate = hireDate;
        this.deptDetail = deptDetail;
    }

}
