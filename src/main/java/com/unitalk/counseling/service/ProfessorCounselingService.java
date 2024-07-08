package com.unitalk.counseling.service;

import com.unitalk.common.exception.ExceptionCode;
import com.unitalk.common.exception.NotFoundException;
import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.Student;
import com.unitalk.counseling.dto.request.CounselingCreateRequest;
import com.unitalk.counseling.dto.response.CounselingResponse;
import com.unitalk.counseling.dto.response.CounselingScheduleResponse;
import com.unitalk.counseling.model.entity.Counseling;
import com.unitalk.counseling.model.entity.CounselorSchedule;
import com.unitalk.counseling.repository.CounselingRepository;
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
public class ProfessorCounselingService {

    private final ModelMapper modelMapper;       // dto to entity
    private final CounselingRepository counselingRepository;
    private final CounselorScheduleRepository counselorScheduleRepository;
    private final StudentRepository studentRepository;
    private final EmployeeRepository employeeRepository;

    private Pageable getPageable(final Integer page) {
        return PageRequest.of(page -1, 10, Sort.by("reqNo").descending());
    }

    /* 목록 조회 : 페이징  */
    @Transactional(readOnly = true)
    public Page<CounselingResponse> getPagingList(final Integer page) {

        Page<Counseling> list = counselingRepository.findAll(getPageable(page));
        // Counseling Entity가 노출되면 위험하기 때문에 Page<>에서 내보낼 때 dto 타입이어야 한다.

        return list.map(counseling -> CounselingResponse.from(counseling));
    }

    /* 목록 조회 : 학생번호 검색, 페이징*/
    @Transactional(readOnly = true)
    public Page<CounselingResponse> getByStudentNo(final Integer page, final Long studentNo) {

        Page<Counseling> list = counselingRepository.findByStudent_studentNo(getPageable(page), studentNo);

        return list.map(CounselingResponse::from);
    }

    /* 상세 조회 : pk로 1건 조회 */
    @Transactional(readOnly = true)
    public CounselingResponse getCounseling(final Long reqNo){
        Counseling counseling = counselingRepository.findById(reqNo)
                .orElseThrow(() -> new NotFoundException(ExceptionCode.NO_DATA));
        return CounselingResponse.from(counseling);
    }

    /* 상담 등록 */
    public Long save(final CounselingCreateRequest counselingCreateRequest) {

        Counseling newCounseling = modelMapper.map(counselingCreateRequest, Counseling.class);

        Student student = studentRepository.findById(counselingCreateRequest.getStudentNo())
                .orElseThrow(() -> new NotFoundException(ExceptionCode.NO_DATA));

        Employee employee = employeeRepository.findById(counselingCreateRequest.getEmployeeNo())
                .orElseThrow(() -> new NotFoundException(ExceptionCode.NO_DATA));

        CounselorSchedule counselorSchedule = counselorScheduleRepository.findById(counselingCreateRequest.getSchNo())
                .orElseThrow(() -> new NotFoundException(ExceptionCode.NO_DATA));

        //작성자학생(나)정보 담기
        newCounseling.setStudent(student);
        //저장시 선택한 직원정보 담기
        newCounseling.setEmployee(employee);
        //저장시 선택한 시간표정보담기
        newCounseling.setCounselorSchedule(counselorSchedule);

        //log.info(" newCounseling >>>>>>>>>> : {}",newCounseling.toString());

        return counselingRepository.save(newCounseling).getReqNo();
    }

    /* 삭제 */
    public void delete(final Long reqNo) {
        counselingRepository.deleteById(reqNo);
    }
}
