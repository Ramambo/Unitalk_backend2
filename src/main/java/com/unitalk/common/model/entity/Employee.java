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

    //교직원 일련번호, PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_no", nullable = false)
    private Long employeeNo;

    //교직원 ID(직번)
    @OneToOne
    @JoinColumn(name = "employee_id", unique = true, nullable = false, referencedColumnName = "user_id")
    private User user;

    //입사연월일
    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    //교직원구분 : PRO 프로페서, COUN 카운슬러, EMP 교직원
    @Column(name = "dept_detail", nullable = false)
    private String deptDetail;

    //교직원 구분이 "교직원"인지 확인
    public boolean isStaff() {
        return "EMP".equals(deptDetail);
    }

    //교직원 구분이 "상담사"인지 확인
    public boolean isCounselor() {
        return "COUN".equals(deptDetail);
    }

    @Builder
    private Employee(User user, LocalDate hireDate, String deptDetail) {
        this.user = user;
        this.hireDate = hireDate;
        this.deptDetail = deptDetail;
    }

}
