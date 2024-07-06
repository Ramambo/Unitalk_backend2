package com.unitalk.counseling.repository;

import com.unitalk.counseling.model.entity.Counseling;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CounselingRepository extends JpaRepository<Counseling, Long> {

    //학생 id로 상담 신청 기록 검색
    Page<Counseling> findByStudent_studentId(Pageable pageable, Long studentId);

}
