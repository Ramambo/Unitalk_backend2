package com.unitalk.program.model.dto.request;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.program.model.entity.Program;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramRequest {
    private Employee counselorCode; // 상담사 코드(FK)
    private String programName; // 집단상담명
    private String programContent; // 집단상담 내용
    private LocalDateTime recruitStart; // 모집시작일
    private LocalDateTime recruitEnd; // 모집종료일
    private LocalDateTime operationStart; // 운영시작일
    private LocalDateTime operationEnd; // 운영종료일
    private Integer programSession; // 회차
    private Integer recruitNum; // 모집인원
    private Character status; // 상태
    private Integer viewCnt; // 조회수

    // DTO 객체를 엔티티로 변환
    public Program toEntity() {
        return Program.builder()
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
}

