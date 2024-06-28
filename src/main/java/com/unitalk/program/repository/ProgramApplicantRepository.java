package com.unitalk.program.repository;

import com.unitalk.program.model.entity.ProgramApplicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramApplicantRepository extends JpaRepository<ProgramApplicant, Integer> {
}
