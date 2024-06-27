package com.unitalk.emp.model.dto;

import com.unitalk.common.model.entity.ProfessorAssignment;
import com.unitalk.common.model.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProfessorAssignmentResponse {

    private Integer assignmentId;
    private User studentId;
    private User professorId;
    private LocalDateTime assignmentDate;

    public ProfessorAssignmentResponse(ProfessorAssignment entity) {
        this.assignmentId = entity.getAssignmentId();
        this.studentId = entity.getStudentId();
        this.professorId = entity.getProfessorId();
        this.assignmentDate = entity.getAssignmentDate();
    }

}
