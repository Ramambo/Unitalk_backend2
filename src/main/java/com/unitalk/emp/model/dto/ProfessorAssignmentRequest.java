package com.unitalk.emp.model.dto;

import com.unitalk.common.model.entity.ProfessorAssignment;
import com.unitalk.common.model.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfessorAssignmentRequest {

    private User studentId;
    private User professorId;

    public ProfessorAssignment toEntity() {
        return ProfessorAssignment.builder()
                .studentId(studentId)
                .professorId(professorId)
                .build();
    }

}
