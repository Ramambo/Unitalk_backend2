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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId; // 학생 ID(PK)

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "studentCode", referencedColumnName = "userCode", nullable = false)
    private User studentCode; // 학생 코드(학번)

    @Column(nullable = false)
    private String name; // 이름

    @Column(nullable = false)
    private Integer grade; // 학년

    @Column(nullable = false)
    private String degreeCourse; // 학위 과정: 학사, 석사, 박사, 석박사 통합

    @Column(nullable = false)
    private LocalDateTime admissionDate; // 입학일

    @Column(nullable = false)
    private String academicStatus; // 학적: 재학, 휴학, 제적, 졸업, 수료

    @Column(nullable = false)
    private LocalDateTime birthday; // 생년월일

    @Column(nullable = false)
    private String email; // 이메일

    @Column(nullable = false)
    private String phone; // 전화번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor", referencedColumnName = "empCode", nullable = false)
    private Employee advisor; // 지도교수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptCode", referencedColumnName = "deptCode", nullable = false)
    private Department deptCode; // 학과 코드
}
