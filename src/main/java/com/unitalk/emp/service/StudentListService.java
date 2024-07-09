package com.unitalk.emp.service;

import com.unitalk.emp.model.dto.StudentListItem;

import java.util.List;

public interface StudentListService {
    //전체 학생목록 조회
    List<StudentListItem> getAllStudents();

    //학과별 학생목록 조회
    List<StudentListItem> getStudentsByDeptId(String deptId);
}
