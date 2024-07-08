package com.unitalk.common.service;

import com.unitalk.emp.model.dto.StudentListItem;

import java.awt.print.Pageable;
import java.util.List;

public interface StudentService {
    List<StudentListItem> getAllStudents();
}
