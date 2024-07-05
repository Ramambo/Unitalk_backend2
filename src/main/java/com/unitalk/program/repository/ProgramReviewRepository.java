package com.unitalk.program.repository;

import com.unitalk.program.model.entity.ProgramReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramReviewRepository extends JpaRepository<ProgramReview, Long> {
}
