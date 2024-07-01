package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Employees")
@Getter
@NoArgsConstructor
//교직원정보 Entity
public class Employee {

    @Id
    @Column(name = "employee_id", nullable = false)
    private Integer employeeId; //교직원 ID(직번)

    @Column(name = "dept_id", nullable = false)
    private String deptId; //부서코드(부서/학과)

    @Column(name = "login_no", nullable = false)
    private Integer loginNo; //로그인일련번호

    @Column(name = "employee_name", nullable = false)
    private String employeeName; //교직원 이름

    @Column(name = "employee_email", nullable = false)
    private String employeeEmail; //교직원 이메일

    @Column(name = "employee_phone_number", nullable = false)
    private String employeePhoneNumber; //교직원 전화번호
    
    @Column(name = "employee_registration_year", nullable = false)
    private LocalDate employeeRegistrationYear; //입사연월일

    @Column(name = "dept_detail", nullable = false)
    private String deptDetail; //교직원구분

    @Builder
    private Employee(Integer employeeId, String deptId, Integer loginNo, String employeeName, String employeeEmail, String employeePhoneNumber, LocalDate employeeRegistrationYear, String deptDetail) {
        this.employeeId = employeeId;
        this.deptId = deptId;
        this.loginNo = loginNo;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeeRegistrationYear = employeeRegistrationYear;
        this.deptDetail = deptDetail;
    }

}
