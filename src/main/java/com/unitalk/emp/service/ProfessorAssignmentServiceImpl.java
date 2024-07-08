package com.unitalk.emp.service;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.ProfessorAssignment;
import com.unitalk.common.model.entity.Student;
import com.unitalk.common.model.entity.User;
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
    private final EmployeeRepository employeeRepository;

    @Autowired
    public ProfessorAssignmentServiceImpl(ProfessorAssignmentRepository professorAssignmentRepository, StudentRepository studentRepository, EmployeeRepository employeeRepository) {
        this.professorAssignmentRepository = professorAssignmentRepository;
        this.studentRepository = studentRepository;
        this.employeeRepository = employeeRepository;
    }

    //지도교수 배정 이력 조회
    public List<ProfessorAssignmentListItem> getAllAssignments() {
        // 모든 배정 이력을 가져와서 DTO 리스트로 변환하여 반환합니다.
        return professorAssignmentRepository.findAll().stream().map(professorAssignment -> {
                    // ProfessorAssignment 엔티티에서 교수와 학생의 ID를 가져옵니다.
                    Student student = professorAssignment.getStudentId();
                    Employee professor = professorAssignment.getProfessorId();

                    student.setUser(student.getUser());
                    professor.setUser(professor.getUser());

                    // Student와 Professor의 User 객체를 가져옵니다.
                    User studentUser = student.getUser();
                    User professorUser = professor.getUser();

                    String studentDeptId = studentUser.getDeptId().getDeptName();
                    String professorDeptId = professorUser.getDeptId().getDeptName();


            // ProfessorAssignmentListItem DTO로 변환
            return new ProfessorAssignmentListItem(
                    professorAssignment.getAssignmentId(),
                    professorUser.getUserId(),
                    professorDeptId,
                    professorUser.getUserName(),
                    studentUser.getUserId(),
                    studentDeptId,
                    studentUser.getUserName(),
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

        Employee professor = employeeRepository.findById(params.getProfessorId()).orElseThrow(() -> new IllegalArgumentException("Invalid professor ID"));
        Student student = studentRepository.findById(params.getStudentId()).orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

        // ProfessorAssignment 엔티티 생성 및 저장
        ProfessorAssignment professorAssignment = params.toEntity(professor, student);
        professorAssignmentRepository.save(professorAssignment);

        // Student 엔티티 업데이트
        student.setProfessorId(professor);
        studentRepository.save(student);

        return professorAssignment.getAssignmentId();
    }

}