package com.unitalk.emp.service;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.Student;
import com.unitalk.common.model.entity.User;
import com.unitalk.emp.model.dto.StudentListItem;
import com.unitalk.emp.repository.StudentListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentListServiceImpl implements StudentListService {

    private final StudentListRepository studentListRepository;

    @Autowired
    public StudentListServiceImpl(StudentListRepository studentListRepository) {
        this.studentListRepository = studentListRepository;
    }

    //전체 학생목록 조회
    @Override
    public List<StudentListItem> getAllStudents() {
        //전체 학생들의 정보를 데이터베이스에서 조회합니다.
        List<Student> students = studentListRepository.findAll();
        return students.stream()
                .map(student -> {
                    User studentUser = student.getUser();
                    String studentDeptId = studentUser.getDeptId().getDeptName();
                    Employee professorId = student.getProfessorId();
                    String professorName = professorId != null ? professorId.getUser().getUserName() : "미배정";

                    return new StudentListItem(
                            student.getStudentNo(),
                            studentUser.getUserId(),
                            studentDeptId,
                            studentUser.getUserName(),
                            studentUser.getEmail(),
                            studentUser.getTel(),
                            student.getGrade(),
                            professorName
                    );
                })
                .collect(Collectors.toList());
    }

}
