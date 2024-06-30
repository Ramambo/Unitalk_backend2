package com.unitalk.program.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "Program_Result")
public class ProgramResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resultId; // 집단상담 결과 번호(PK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programId", nullable = false)
    private Program programId; // 집단상담 번호(FK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counselorCode", referencedColumnName = "counselorCode", nullable = false)
    private Program counselorCode; // 상담사 코드(FK)

    @Column(nullable = false)
    private String resultContent; // 집단상담 결과 내용

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime resultDate;  // 집단상담 작성일

    @Column(nullable = false)
    private Integer participantNum;  // 집단상담 참여인원

    @Column(nullable = false)
    private Integer programSession;  // 집단상담 회차

    @Column(nullable = false)
    private LocalDateTime operationDate;  // 집단상담 운영일

}

