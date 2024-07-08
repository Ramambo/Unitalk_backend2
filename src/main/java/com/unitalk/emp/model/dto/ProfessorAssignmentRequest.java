package com.unitalk.emp.model.dto;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.ProfessorAssignment;
import com.unitalk.common.model.entity.Student;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfessorAssignmentRequest {

    private Long professorId;
    private Long studentId;

    public ProfessorAssignment toEntity(Employee professor, Student student) {
        return ProfessorAssignment.builder()
                .professorId(professor)
                .studentId(student)
                .build();
    }

}
