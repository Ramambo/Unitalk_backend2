package com.unitalk.emp.repository;

import com.unitalk.common.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentListRepository extends JpaRepository<Student, Long> {

}
