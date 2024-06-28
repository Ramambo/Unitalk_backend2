package com.unitalk.program.model.dto.response;

import com.unitalk.common.model.entity.User;
import com.unitalk.program.model.entity.ProgramFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramResponse {
    private Integer programId; // 집단상담 ID(PK)
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
    private Integer viewCnt; // 조회수
    private List<ProgramFile> programFiles; // 집단상담 파일 리스트
}
