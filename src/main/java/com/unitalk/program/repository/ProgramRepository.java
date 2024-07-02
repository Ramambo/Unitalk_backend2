package com.unitalk.program.repository;

import com.unitalk.program.model.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramRepository extends JpaRepository<Program, Integer> {
    List<Program> findAllByOrderByProgramIdDesc();
}
