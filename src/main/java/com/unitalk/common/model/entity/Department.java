package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "Departments")
@Getter
@Builder
@NoArgsConstructor
//부서정보 Entity
public class Department {

    @Id
    @Column(name = "dept_id", nullable = false)
    private String deptId; //부서코드, PK

    @Column(name = "dept_name", nullable = false)
    private String deptName; //부서명

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "up_dept_id", nullable = false)
    private Department upDeptId; //상위부서코드, FK (재귀)

    @OneToMany(mappedBy = "upDept")
    private Set<Department> subDepts;

    @Builder
    public Department(String deptId, String deptName, Department upDeptId, Set<Department> subDepts) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.upDeptId = upDeptId;
        this.subDepts = subDepts;
    }

}
