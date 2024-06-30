package com.unitalk.program.model.dto.request;

import com.unitalk.common.model.entity.Student;
import com.unitalk.program.model.entity.Program;
import com.unitalk.program.model.entity.ProgramApplicant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramApplicantRequest {
    private Program programId; // 집단상담 번호(FK)
    private Student studentCode; // 학생 코드(FK)
    private Character status; // 신청상태

    // DTO 객체를 엔티티로 변환
    public ProgramApplicant toEntity() {
        return ProgramApplicant.builder()
                .programId(programId)
                .studentCode(studentCode)
                .status(status)
                .build();
    }
}
