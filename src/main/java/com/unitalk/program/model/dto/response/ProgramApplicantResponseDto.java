package com.unitalk.program.model.dto.response;

import com.unitalk.program.model.entity.Program;
import com.unitalk.program.model.entity.ProgramApplicant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramApplicantResponseDto {
    private Long applicantNo; // 집단상담 신청 번호
    private Program program; // 집단상담
    private Long userId; // 학번
    private String userName; // 학생명
    private LocalDate applicantDate; // 집단상담 신청일
    private Long status; // 상태

// ProgramApplicant 엔티티를 받아 DTO로 변환하는 생성자
    public ProgramApplicantResponseDto(ProgramApplicant programApplicant) {
        this.applicantNo = programApplicant.getApplicantNo();
        this.program = programApplicant.getProgram();
        this.userId = programApplicant.getStudent().getUser().getUserId();
        this.applicantDate = programApplicant.getApplicantDate();
        this.status = programApplicant.getStatus();
    }
}
