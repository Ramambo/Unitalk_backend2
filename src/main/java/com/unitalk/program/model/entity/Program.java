package com.unitalk.program.model.entity;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.program.model.dto.response.ProgramResponse;
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

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(unique = false, name = "counselorCode", referencedColumnName = "empCode", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    // foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT) 외래키 삭제
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

    public ProgramResponse toDto() {
        return ProgramResponse.builder()
                .programId(programId)
                .counselorCode(counselorCode)
                .programName(programName)
                .programContent(programContent)
                .recruitStart(recruitStart)
                .recruitEnd(recruitEnd)
                .operationStart(operationStart)
                .operationEnd(operationEnd)
                .programSession(programSession)
                .recruitNum(recruitNum)
                .status(status)
                .viewCnt(viewCnt)
                .build();
    }

    // 엔티티 필드 업데이트
    public void update(String programName, String programContent, LocalDateTime recruitStart, LocalDateTime recruitEnd,
                       LocalDateTime operationStart, LocalDateTime operationEnd, Integer programSession,
                       Integer recruitNum, Character status, Integer viewCnt) {
        this.programName = programName;
        this.programContent = programContent;
        this.recruitStart = recruitStart;
        this.recruitEnd = recruitEnd;
        this.operationStart = operationStart;
        this.operationEnd = operationEnd;
        this.programSession = programSession;
        this.recruitNum = recruitNum;
        this.status = status;
        this.viewCnt = viewCnt;
    }

}
