package com.unitalk.emp.service;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.ProfessorAssignment;
import com.unitalk.common.model.entity.Student;
import com.unitalk.common.repository.EmployeeRepository;
import com.unitalk.common.repository.StudentRepository;
import com.unitalk.emp.model.dto.ProfessorAssignmentRequest;
import com.unitalk.emp.repository.ProfessorAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorAssignmentServiceImpl implements ProfessorAssignmentService {

    private final ProfessorAssignmentRepository professorAssignmentRepository;
    private final StudentRepository studentRepository;
    private final EmployeeRepository employeeRepository; // 추가

    @Autowired
    public ProfessorAssignmentServiceImpl(ProfessorAssignmentRepository professorAssignmentRepository, StudentRepository studentRepository, EmployeeRepository employeeRepository) {
        this.professorAssignmentRepository = professorAssignmentRepository;
        this.studentRepository = studentRepository; // 추가
        this.employeeRepository = employeeRepository; // 추가
    }

    //지도교수 배정 이력 생성
    @Override
    public Long save(ProfessorAssignmentRequest params) {
        ProfessorAssignment professorAssignment = params.toEntity();
        professorAssignmentRepository.save(professorAssignment);

        // 학생의 지도 교수 업데이트
        Student student = studentRepository.findById(professorAssignment.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Employee professor = employeeRepository.findById(professorAssignment.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Professor not found"));
        student.setEmployeeId(professor);
        studentRepository.save(student);

        return professorAssignment.getAssignmentId();
    }

}