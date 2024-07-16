package com.unitalk.program.repository;

import com.unitalk.common.model.entity.Student;
import com.unitalk.program.model.entity.Program;
import com.unitalk.program.model.entity.ProgramApplicant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ProgramApplicantRepository extends JpaRepository<ProgramApplicant, Long> {

    // 모든 신청 조회
    Page<ProgramApplicant> findAllByOrderByApplicantDateDesc(Pageable pageable);

    // 모든 신청 필터 및 조회
    @Query("SELECT pa FROM ProgramApplicant pa WHERE " +
            "(:programNo IS NULL OR pa.program.programNo = :programNo) " +
            "AND (:studentNo IS NULL OR pa.student.studentNo = :studentNo) " +
            "AND (:applicantDate IS NULL OR pa.applicantDate = :applicantDate) " +
            "AND (:status IS NULL OR pa.status = :status)")

    Page<ProgramApplicant> findByFilters(
            @Param("programNo") Long programNo,
            @Param("studentNo") Long studentNo,
            @Param("applicantDate") LocalDate applicantDate,
            @Param("status") Long status,
            Pageable pageable
    );

    // 학생이 자신의 신청 조회
    @Query("SELECT pa FROM ProgramApplicant pa WHERE pa.student.user.userId = :studentId ORDER BY pa.applicantDate DESC")
    Page<ProgramApplicant> findByStudentUserUserIdOrderByApplicantDateDesc(
            @Param("studentId") Long studentId,
            Pageable pageable
    );

    // 프로그램과 학생, 상태를 기반으로 신청이 존재하는지 확인
    @Query("SELECT pa FROM ProgramApplicant pa WHERE pa.program.programNo = :programNo AND pa.student.studentNo = :studentNo")
    ProgramApplicant findByProgramNoAndStudentStudentNo(@Param("programNo") Long programNo, @Param("studentNo") Long studentNo);

    // 특정 프로그램 신청인 목록
    @Query("SELECT pa FROM ProgramApplicant pa WHERE pa.program.programNo = :programNo")
    Page<ProgramApplicant> findByProgramNo(@Param("programNo") Long programNo, Pageable pageable);

    // 특정 프로그램 신청인 목록 필터 및 검색
    @Query("SELECT pa FROM ProgramApplicant pa WHERE " +
            "pa.program.programNo = :programNo " +
            "AND (:studentName IS NULL OR pa.student.user.userName = :studentName) " +
            "AND (:applicantDate IS NULL OR pa.applicantDate = :applicantDate) " +
            "AND (:status IS NULL OR pa.status = :status)")
    Page<ProgramApplicant> findByProgramNoWithFilters(
            @Param("programNo") Long programNo,
            @Param("studentName") String studentName,
            @Param("applicantDate") LocalDate applicantDate,
            @Param("status") Long status,
            Pageable pageable
    );

    // 완료 상태 업데이트 쿼리
    @Modifying
    @Query("UPDATE ProgramApplicant pa SET pa.status = 3 " +
            "WHERE pa.status = 1 AND :now > pa.program.operationEnd")
    void updateStatus(@Param("now") LocalDate now);

}
