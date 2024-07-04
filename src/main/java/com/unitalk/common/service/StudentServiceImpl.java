package com.unitalk.common.service;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.Student;
import com.unitalk.common.repository.StudentRepository;
import com.unitalk.emp.model.dto.StudentListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //전체 학생목록 조회
    @Override
    public List<StudentListItem> getAllStudents() {
        //전체 학생들의 정보를 데이터베이스에서 조회합니다.
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> {
                    Employee employee = student.getEmployee();
                    String employeeName = employee != null ? employee.getEmployeeName() : "미배정";
                    return new StudentListItem(
                            student.getStudentId(),
                            student.getDeptId(),
                            student.getStudentName(),
                            student.getStudentEmail(),
                            student.getStudentPhoneNumber(),
                            student.getGrade(),
                            employeeName
                    );
                })
                .collect(Collectors.toList());
    }
}

