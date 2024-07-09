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
    private Employee professorNo;
    private Student studentNo;
    private LocalDateTime assignmentDate;

    public ProfessorAssignmentResponse(ProfessorAssignment entity) {
        this.assignmentId = entity.getAssignmentId();
        this.professorNo = entity.getProfessorNo();
        this.studentNo = entity.getStudentNo();
        this.assignmentDate = entity.getAssignmentDate();
    }

}
