package com.unitalk.program.repository;

import com.unitalk.program.model.entity.Program;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
    @Query("SELECT p FROM Program p WHERE " +
            "(:counselorNo IS NULL OR p.counselor.id = :counselorNo) " +
            "AND (:keyword IS NULL OR LOWER(p.programName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.programContent) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
            "AND (:programName IS NULL OR p.programName LIKE %:programName%) " +
            "AND (:programContent IS NULL OR p.programContent LIKE %:programContent%) " +
            "AND (:recruitStart IS NULL OR p.recruitStart >= :recruitStart) " +
            "AND (:recruitEnd IS NULL OR p.recruitEnd <= :recruitEnd) " +
            "AND (:operationStart IS NULL OR p.operationStart >= :operationStart) " +
            "AND (:operationEnd IS NULL OR p.operationEnd <= :operationEnd) " +
            "AND (:status IS NULL OR p.status = :status) " +
            "AND (:viewCnt IS NULL OR p.viewCnt >= :viewCnt)")
    Page<Program> findByFilters(
            @Param("counselorNo") Long counselorNo,
            @Param("keyword") String keyword,
            @Param("programName") String programName,
            @Param("programContent") String programContent,
            @Param("recruitStart") LocalDate recruitStart,
            @Param("recruitEnd") LocalDate recruitEnd,
            @Param("operationStart") LocalDate operationStart,
            @Param("operationEnd") LocalDate operationEnd,
            @Param("status") Long status,
            @Param("viewCnt") Long viewCnt,
            Pageable pageable
    );

    Page<Program> findAllByOrderByProgramNoDesc(Pageable pageable);

    // 취소 상태 업데이트 쿼리
    @Modifying
    @Query("UPDATE Program p SET p.status = " +
            "CASE " +
            "WHEN :now BETWEEN p.recruitStart AND p.recruitEnd THEN 1 " +
            "ELSE 2 " +
            "END")
    void updateStatus(@Param("now") LocalDate now);

    // 메인페이지 TOP12
    @Query("SELECT p FROM Program p WHERE p.status = 1 ORDER BY p.viewCnt DESC")
    Page<Program> findTop12ByStatusOrderByViewCntDesc(Pageable pageable);

}