package com.unitalk.counseling.repository;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.Student;
import com.unitalk.counseling.model.entity.Counseling;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounselingRepository extends JpaRepository<Counseling, Long> {
    Page<Counseling> findByStudentOrderByApplicationDateDesc(Student student, Pageable pageable);
    Page<Counseling> findByCounselorIdOrderByApplicationDateDesc(Employee counselor, Pageable pageable);
}
