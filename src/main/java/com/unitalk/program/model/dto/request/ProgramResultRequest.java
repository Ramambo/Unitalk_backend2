package com.unitalk.program.model.dto.request;

import com.unitalk.program.model.entity.Program;
import com.unitalk.program.model.entity.ProgramResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramResultRequest {
    private Program programId; // 집단상담 번호(FK)
    private String resultContent; // 집단상담 결과 내용
    private Integer participantNum;  // 집단상담 참여인원
    private Integer programSession;  // 집단상담 회차
    private LocalDateTime operationDate;  // 집단상담 운영일

    // DTO 객체를 엔티티로 변환
    public ProgramResult toEntity() {
        return ProgramResult.builder()
                .programId(programId)
                .resultContent(resultContent)
                .participantNum(participantNum)
                .programSession(programSession)
                .operationDate(operationDate)
                .build();
    }
}
