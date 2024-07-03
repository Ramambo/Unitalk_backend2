package com.unitalk.program.repository;

import com.unitalk.program.model.entity.Program;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProgramRepository extends JpaRepository<Program, Integer> {
    List<Program> findAllByOrderByProgramIdDesc();

    // 검색
    @Query("SELECT p FROM Program p WHERE p.programName LIKE %:keyword% OR p.programContent LIKE %:keyword%")
    Page<Program> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
