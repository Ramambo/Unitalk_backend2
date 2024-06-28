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
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userNo; //사용자 번호(PK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptId", nullable = false)
    private Department deptId; //부서 ID(FK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private LoginInfo userId; //사용자 ID(FK), 학번 및 교번

    @Column(nullable = false)
    private String userame; //시용자 이름

    private String email; // 사용자 이메일

    private String phoneNumber; // 사용자 전화번호

    @Column(nullable = false)
    private LocalDateTime registrationYear; // 입사(학)년도
}