package com.unitalk.program.model.entity;

import com.unitalk.common.model.entity.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "Program")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer programId; // 집단상담 번호(PK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counselorCode", referencedColumnName = "empCode", nullable = false)
    private Employee counselorCode; // 상담사 코드(FK)

    @Column(nullable = false)
    private String programName; // 집단상담명

    @Column(nullable = false)
    private String programContent; // 집단상담 내용

    private LocalDateTime recruitStart; // 모집시작일

    private LocalDateTime recruitEnd; // 모집종료일

    private LocalDateTime operationStart; // 운영시작일

    private LocalDateTime operationEnd; // 운영종료일

    @ColumnDefault("1") // 기본값 1
    private Integer programSession; // 회차

    private Integer recruitNum; // 모집인원

    @Column(nullable = false)
    private Character status; // 상태

    @ColumnDefault("0") // 기본값 0
    private Integer viewCnt; // 조회수
}
