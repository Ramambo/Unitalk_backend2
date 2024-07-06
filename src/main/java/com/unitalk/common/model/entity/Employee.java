package com.unitalk.common.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "employeeNo")
public class Employee {

    @Id
    @Column(name = "employee_no", nullable = false) // 교직원일련번호
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeNo;

    @OneToOne
    @JoinColumn(name = "employee_id", unique = true, nullable = false) // 학생번호
    private User user;

    @Column(name = "hire_date", nullable = false)   // 입사일
    private LocalDate hireDate;

    @Column(name = "dept_detail")   // 교직원구분
    private String deptDetail;

    // 교직원 구분이 "교직원" 확인
    public boolean isStaff() {
        return "교직원".equals(deptDetail);
    }

    // 상담사 구분 확인 메서드
    public boolean isCounselor() {
        return "상담사".equals(deptDetail);
    }

}