package com.unitalk.emp.service;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.ProfessorAssignment;
import com.unitalk.common.model.entity.Student;
import com.unitalk.common.repository.EmployeeRepository;
import com.unitalk.common.repository.StudentRepository;
import com.unitalk.emp.model.dto.ProfessorAssignmentListItem;
import com.unitalk.emp.model.dto.ProfessorAssignmentRequest;
import com.unitalk.emp.repository.ProfessorAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

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

    //지도교수 배정 이력 조회
    public List<ProfessorAssignmentListItem> getAllAssignments() {
        // 모든 배정 이력을 가져와서 DTO 리스트로 변환하여 반환합니다.
        return professorAssignmentRepository.findAll().stream().map(professorAssignment -> {
            Student student = studentRepository.findById(professorAssignment.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            Employee professor = employeeRepository.findById(professorAssignment.getProfessorId())
                    .orElseThrow(() -> new RuntimeException("Professor not found"));

            // ProfessorAssignmentListItem DTO로 변환
            return new ProfessorAssignmentListItem(
                    professorAssignment.getAssignmentId(),
                    professor.getEmployeeId(),
                    professor.getDeptId(),
                    professor.getEmployeeName(),
                    student.getStudentId(),
                    student.getDeptId(),
                    student.getStudentName(),
                    professorAssignment.getAssignmentDate()
            );
        })
                //최신순으로 정렬하기
                .sorted(Comparator.comparingLong(ProfessorAssignmentListItem::getAssignmentId).reversed())
                .collect(Collectors.toList());
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