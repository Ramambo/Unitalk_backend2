package com.unitalk.emp.model.dto;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.ProfessorAssignment;
import com.unitalk.common.model.entity.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ProfessorAssignmentResponse {

    private Long assignmentId;
    private Employee professorId;
    private Student studentId;
    private LocalDateTime assignmentDate;

    public ProfessorAssignmentResponse(ProfessorAssignment entity) {
        this.assignmentId = entity.getAssignmentId();
        this.professorId = entity.getProfessorId();
        this.studentId = entity.getStudentId();
        this.assignmentDate = entity.getAssignmentDate();
    }

}
