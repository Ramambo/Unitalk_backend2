package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId; // 교직원 번호

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empCode", referencedColumnName = "userCode", nullable = false)
    private User empCode; // 교직원 코드(학번)

    @Column(nullable = false)
    private String name; // 이름

    @Column(nullable = false)
    private String degree; // 학위: 학사, 석사, 박사

    @Column(nullable = false)
    private LocalDate hireDate; // 입사일

    @Column(nullable = false)
    private LocalDate birthday; // 생년월일

    @Column(nullable = false)
    private String email; // 이메일

    @Column(nullable = false)
    private String phone; // 전화번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptCode", referencedColumnName = "deptCode", nullable = false)
    private Department deptCode; // 부서 코드
}
