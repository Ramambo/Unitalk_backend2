package com.unitalk.program.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramRequestDto {
    private Long counselorNo; // 상담사
    private String programName; // 집단상담명
    private String programContent; // 집단상담 내용
    private LocalDate recruitStart; // 모집시작일
    private LocalDate recruitEnd; // 모집종료일
    private LocalDate operationStart; // 운영시작일
    private LocalDate operationEnd; // 운영종료일
    private Long programSession; // 회차
    private Long recruitNum; // 모집인원
    private Character status; // 상태
    private Long viewCnt; // 조회수
}
