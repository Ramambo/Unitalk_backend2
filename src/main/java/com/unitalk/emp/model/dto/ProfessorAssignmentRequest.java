package com.unitalk.emp.model.dto;

import com.unitalk.common.model.entity.ProfessorAssignment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfessorAssignmentRequest {

    private Integer professorId;
    private Integer studentId;

    public ProfessorAssignment toEntity() {
        return ProfessorAssignment.builder()
                .professorId(professorId)
                .studentId(studentId)
                .build();
    }

}
