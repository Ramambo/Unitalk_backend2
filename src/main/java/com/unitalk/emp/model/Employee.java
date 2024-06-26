package com.unitalk.emp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
// 교직원 Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId; // 교직원번호, PK
    private Integer deptId; // 부서코드, FK
    private Integer userId; // 사용자 ID, FK
    private String userName; // 사용자 이름
    private String email; // 사용자 이메일
    private String phoneNumber; // 사용자 연락처
    private LocalDateTime registrationYear; // 입사(학)년도

}
