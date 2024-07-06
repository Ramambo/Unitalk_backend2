package com.unitalk.counseling.repository;

import com.unitalk.counseling.model.entity.CounselorSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounselorScheduleRepository extends JpaRepository<CounselorSchedule,Long> {

    //교수아이디로 상담 가능 날짜(요일별 시간) 조회(이름으로 하면 중복이 나올 수 있다)
    Page<CounselorSchedule> findByEmpId(Pageable pageable, Long empId);
}
