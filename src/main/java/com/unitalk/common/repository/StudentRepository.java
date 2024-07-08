package com.unitalk.common.repository;

import com.unitalk.common.model.entity.Student;
import com.unitalk.emp.model.dto.StudentListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}