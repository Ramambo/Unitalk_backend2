package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "Students")
public class Student {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentCode", unique = true, referencedColumnName = "userCode")
    private User studentCode; // 사용자 엔티티와 매핑

    @Column(nullable = false)
    private String name; // 이름

    @Column(nullable = false)
    private Integer grade; // 학년

    @Column(nullable = false)
    private LocalDateTime admissionDate; // 입학일

    @Column(nullable = false)
    private String email; // 이메일

    @Column(nullable = false)
    private String phone; // 전화번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empCode", referencedColumnName = "empCode", nullable = false)
    private Employee empCode; // 지도교수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptCode", referencedColumnName = "deptCode", nullable = false)
    private Department deptCode; // 학과 코드
}
