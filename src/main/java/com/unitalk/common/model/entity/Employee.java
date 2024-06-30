package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "Employees")
public class Employee {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empCode", unique = true, referencedColumnName = "userCode")
    private User empCode;

    @Column(nullable = false)
    private String name; // 이름

    @Column(nullable = false)
    private LocalDate hireDate; // 입사일

    @Column(nullable = false)
    private String email; // 이메일

    @Column(nullable = false)
    private String phone; // 전화번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptCode", referencedColumnName = "deptCode", nullable = false)
    private Department deptCode; // 부서 코드

    @Column(nullable = false)
    private String dept_detail; // 교직원 구분

    @Embeddable
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EmployeeId implements Serializable {
        @OneToOne
        @JoinColumn(name = "empCode", unique = true, referencedColumnName = "userCode")
        private User userCode;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeId that = (EmployeeId) o;
            return Objects.equals(userCode, that.userCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userCode);
        }
    }

}
