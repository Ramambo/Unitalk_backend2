package com.unitalk.program.model.dto.response;

import com.unitalk.common.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramResponse {
    private Integer programId; // 집단상담 번호(PK)
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
}
