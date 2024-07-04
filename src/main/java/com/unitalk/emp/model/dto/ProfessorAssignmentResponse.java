package com.unitalk.emp.model.dto;

import com.unitalk.common.model.entity.ProfessorAssignment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProfessorAssignmentResponse {

    private Long assignmentId;
    private Long professorId;
    private Long studentId;
    private LocalDateTime assignmentDate;

    public ProfessorAssignmentResponse(ProfessorAssignment entity) {
        this.assignmentId = entity.getAssignmentId();
        this.professorId = entity.getProfessorId();
        this.studentId = entity.getStudentId();
        this.assignmentDate = entity.getAssignmentDate();
    }

}
