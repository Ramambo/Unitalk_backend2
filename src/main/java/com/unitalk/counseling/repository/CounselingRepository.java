package com.unitalk.counseling.repository;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.Student;
import com.unitalk.counseling.model.entity.Counseling;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CounselingRepository extends JpaRepository<Counseling, Long> {
    Page<Counseling> findByStudentOrderByApplicationDateDesc(Student student, Pageable pageable);
    Page<Counseling> findByCounselorOrderByApplicationDateDesc(Employee counselor, Pageable pageable);

    List<Counseling> findByStudent_StudentNo(Long studentNo);

    @Query("SELECT c FROM Counseling c WHERE c.student.studentNo = :studentNo " +
            "AND (:counselMode IS NULL OR c.counselMode = :counselMode) " +
            "AND (:status IS NULL OR c.status = :status) " +
            "AND (:counselType IS NULL OR c.department.deptId = :counselType) " +
            "AND (:startDate IS NULL OR c.counselDate >= :startDate) " +
            "AND (:endDate IS NULL OR c.counselDate <= :endDate)")
    Page<Counseling> findByFilters(
            @Param("studentNo") Long studentNo,
            @Param("counselMode") Long counselMode,
            @Param("status") Long status,
            @Param("counselType") String counselType,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable
    );

}
