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
    @OneToOne//(fetch = FetchType.LAZY) // 1:1 관계의 경우 PK 또는 복합키가 해당 컬럼이어야 한다.
    @JoinColumn(name = "empCode", referencedColumnName = "userCode")
    private User empCode;

    @Column(nullable = false)
    private String name; // 이름

    @Column(nullable = false)
    private LocalDate hireDate; // 입사일

    @Column(nullable = false)
    private String email; // 이메일

    @Column(nullable = false)
    private String phone; // 전화번호

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptCode", referencedColumnName = "deptCode", nullable = false)
    private Department deptCode; // 부서 코드

    @Column(nullable = false)
    private String deptDetail; // 교직원 구분
}
