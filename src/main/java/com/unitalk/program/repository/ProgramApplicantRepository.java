package com.unitalk.program.repository;

import com.unitalk.program.model.entity.ProgramApplicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramApplicantRepository extends JpaRepository<ProgramApplicant, Long> {
    List<ProgramApplicant> findAllByOrderByApplicantIdDesc();
}
