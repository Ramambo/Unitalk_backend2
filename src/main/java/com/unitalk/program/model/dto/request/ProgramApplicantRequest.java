package com.unitalk.program.model.dto.request;

import com.unitalk.common.model.entity.User;
import com.unitalk.program.model.entity.Program;
import com.unitalk.program.model.entity.ProgramApplicant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramApplicantRequest {
    private Program programId; // 집단상담 ID
    private User studentId; // 학생 ID
    private Character participationStatus; // 참여 여부

    // DTO 객체를 엔티티로 변환
    public ProgramApplicant toEntity() {
        return ProgramApplicant.builder()
                .programId(programId)
                .studentId(studentId)
                .participationStatus(participationStatus)
                .build();
    }
}
