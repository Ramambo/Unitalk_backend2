package com.unitalk.emp.service;

import com.unitalk.emp.model.dto.StudentListItem;

import java.util.List;

public interface StudentListService {
    List<StudentListItem> getAllStudents();
}
