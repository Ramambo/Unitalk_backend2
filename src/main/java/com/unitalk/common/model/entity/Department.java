package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "Departments")
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @Column(name = "dept_id")   // 부서코드
    private String deptId;

    @Column(name = "dept_name", nullable = false) // 부서명
    private String deptName;

}
