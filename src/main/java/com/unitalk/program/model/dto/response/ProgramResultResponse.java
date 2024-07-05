package com.unitalk.program.model.dto.response;

import com.unitalk.program.model.entity.Program;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramResultResponse {
    private Long resultId; // 집단상담 결과 번호(PK)
    private Program programId; // 집단상담 번호(FK)
    private Program counselorCode; // 상담사 코드(FK)
    private String resultContent; // 집단상담 결과 내용
    private LocalDateTime resultDate;  // 집단상담 작성일
    private Long participantNum;  // 집단상담 참여인원
    private Long programSession;  // 집단상담 회차
    private LocalDateTime operationDate;  // 집단상담 운영일
}
