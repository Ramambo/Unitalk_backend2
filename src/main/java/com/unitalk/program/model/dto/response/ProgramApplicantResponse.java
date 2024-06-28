package com.unitalk.program.model.dto.response;

import com.unitalk.common.model.entity.User;
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
public class ProgramApplicantResponse {
    private Integer applicantId; // 집단상담 신청 ID(PK)
    private Program programId; // 집단상담 ID(FK)
    private User studentId; // 학생 ID(FK)
    private LocalDateTime applicantDate; // 신청일
    private Character participationStatus; // 참여 여부
}
