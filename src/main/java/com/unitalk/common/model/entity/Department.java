package com.unitalk.common.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "Departments")
@Getter
@NoArgsConstructor
//부서정보 Entity
public class Department {

    //부서코드, PK
    @Id
    @Column(name = "dept_id", nullable = false)
    private String deptId;

    //부서명
    @Column(name = "dept_name", nullable = false)
    private String deptName;

    @Builder
    public Department(String deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }
}
