package com.unitalk.counseling.repository;

import com.unitalk.counseling.model.entity.Counseling;
import com.unitalk.counseling.model.entity.CounselorSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounselorScheduleRepository extends JpaRepository<CounselorSchedule,Long> {

    //교수 이름으로 날짜 조회
    Page<Counseling> findByEmployee_EmployeeId(Pageable pageable, Long empId);


}
