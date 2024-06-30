package com.unitalk.program.model.dto.response;

import com.unitalk.common.model.entity.Student;
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
    private Integer applicantId; // 집단상담 신청 번호(PK)
    private Program programId; // 집단상담 번호(FK)
    private Student studentCode; // 학생 코드(FK)
    private LocalDateTime applicantDate; // 신청일
    private Character status; // 신청상태
}
