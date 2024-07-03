package com.unitalk.common.service;

import com.unitalk.emp.model.dto.StudentListItem;

import java.util.List;

public interface StudentService {
    List<StudentListItem> getAllStudents();
}
