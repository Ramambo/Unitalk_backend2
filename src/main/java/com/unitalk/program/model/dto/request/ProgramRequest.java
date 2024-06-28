package com.unitalk.program.model.dto.request;

import com.unitalk.common.model.entity.User;
import com.unitalk.program.model.entity.Program;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramRequest {
    private User counselorId; // 상담사 ID(FK)
    private String programName; // 집단상담명
    private String programContent; // 집단상담 내용
    private LocalDateTime recruitStart; // 모집시작일
    private LocalDateTime recruitEnd; // 모집종료
    private LocalDateTime operationStart; // 운영시작일
    private LocalDateTime operationEnd; // 운영종료일
    private Integer programSession; // 회차
    private Integer recruitNum; // 모집인원
    private Integer participantNum; // 참여인원
    private Character status; // 상태

    // DTO 객체를 엔티티로 변환
    public Program toEntity() {
        return Program.builder()
                .counselorId(counselorId)
                .programName(programName)
                .programContent(programContent)
                .recruitStart(recruitStart)
                .recruitEnd(recruitEnd)
                .operationStart(operationStart)
                .operationEnd(operationEnd)
                .programSession(programSession)
                .recruitNum(recruitNum)
                .participantNum(participantNum)
                .status(status)
                .build();
    }
}

