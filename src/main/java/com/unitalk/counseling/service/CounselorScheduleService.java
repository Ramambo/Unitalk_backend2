package com.unitalk.counseling.service;

import com.unitalk.counseling.dto.response.CounselingScheduleResponse;
import com.unitalk.counseling.model.entity.CounselorSchedule;
import com.unitalk.counseling.repository.CounselorScheduleRepository;
import com.unitalk.counseling.repository.EmployeeRepository;
import com.unitalk.counseling.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor // final이 붙인 생성자 argu를 던져주는 어노테이션
@Transactional
public class CounselorScheduleService {

    private final ModelMapper modelMapper;       // dto to entity
    private final CounselorScheduleRepository counselorScheduleRepository;
    private final StudentRepository studentRepository;
    private final EmployeeRepository employeeRepository;

    private Pageable getPageable(final Integer page) {
        return PageRequest.of(page -1, 10, Sort.by("schNo").descending());
    }

    /* 상담 가능 날짜 조회 : 교수 ID로 */
    @Transactional(readOnly = true)
    public Page<CounselingScheduleResponse> getByEmployeeNo(final Integer page, final Long employeeNo){

        Page<CounselorSchedule> list = counselorScheduleRepository.findByEmployee_employeeNo(getPageable(page), employeeNo);

        return list.map(CounselingScheduleResponse::from);
    }

}
