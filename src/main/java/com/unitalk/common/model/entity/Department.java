package com.unitalk.common.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "Departments")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "deptId")
public class Department {
    @Id
    @Column(nullable = false)
    private String deptId; // 부서 ID(PK)

    @Column(nullable = false)
    private String deptName; // 부서명

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upDeptId")
    private Department upDeptId; // 상위 부서코드(FK)
}
