package com.unitalk.counseling.service;

import com.unitalk.counseling.model.dto.request.CounselingRequestDto;
import com.unitalk.counseling.model.dto.response.CounselingResponseDto;
import com.unitalk.counseling.model.entity.Counseling;
import com.unitalk.counseling.repository.CounselingRepository;
import com.unitalk.common.repository.EmployeeRepository;
import com.unitalk.common.repository.StudentRepository;
import com.unitalk.counseling.repository.CounselorScheduleRepository;
import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
public class CounselingService {

    private final CounselingRepository counselingRepository;
    private final StudentRepository studentRepository;
    private final EmployeeRepository employeeRepository;
    private final CounselorScheduleRepository scheduleRepository;
    private final ModelMapper modelMapper;

    public CounselingService(CounselingRepository counselingRepository,
                             StudentRepository studentRepository,
                             EmployeeRepository employeeRepository,
                             CounselorScheduleRepository scheduleRepository,
                             ModelMapper modelMapper) {
        this.counselingRepository = counselingRepository;
        this.studentRepository = studentRepository;
        this.employeeRepository = employeeRepository;
        this.scheduleRepository = scheduleRepository;
        this.modelMapper = modelMapper;
    }

    // 상담 신청
    @Transactional
    public CounselingResponseDto createCounseling(CounselingRequestDto requestDto) {
        Student student = studentRepository.findById(requestDto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Employee counselor = employeeRepository.findById(requestDto.getCounselorId())
                .orElseThrow(() -> new RuntimeException("Counselor not found"));

        Counseling counseling = modelMapper.map(requestDto, Counseling.class);
        counseling.setStudent(student);
        counseling.setCounselorId(counselor);
        counseling.setSchedule(scheduleRepository.findById(requestDto.getSchNo())
                .orElseThrow(() -> new RuntimeException("Schedule not found")));
        counseling.setStatus(2L);
        counseling.setApplicationDate(LocalDateTime.now());

        Counseling savedCounseling = counselingRepository.save(counseling);
        return modelMapper.map(savedCounseling, CounselingResponseDto.class);
    }

    // 상담 내용 업데이트
    @Transactional
    public CounselingResponseDto updateCounseling(Long reqNo, String counselContent) {
        Counseling counseling = counselingRepository.findById(reqNo)
                .orElseThrow(() -> new RuntimeException("Counseling not found"));
        counseling.setCounselContent(counselContent);
        counseling.setStatus(3L);
        counseling.setRecordTime(LocalDateTime.now());

        Counseling updatedCounseling = counselingRepository.save(counseling);
        return modelMapper.map(updatedCounseling, CounselingResponseDto.class);
    }

    // 상담 신청 번호로 상담 정보 조회
    public CounselingResponseDto getCounselingById(Long reqNo) {
        Counseling counseling = counselingRepository.findById(reqNo)
                .orElseThrow(() -> new RuntimeException("Counseling not found"));
        return modelMapper.map(counseling, CounselingResponseDto.class);
    }

    // 학생ID로 해당 학생의 모든 상담 정보 조회
    public Page<CounselingResponseDto> getCounselingsByStudentId(Long studentId, Pageable pageable) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Page<Counseling> counselings = counselingRepository.findByStudentOrderByApplicationDateDesc(student, pageable);
        return counselings.map(counseling -> modelMapper.map(counseling, CounselingResponseDto.class));
    }

    // 상담자ID로 해당 상담사의 모든 상담 정보 조회
    public Page<CounselingResponseDto> getCounselingsByCounselorId(Long counselorId, Pageable pageable) {
        Employee counselor = employeeRepository.findById(counselorId)
                .orElseThrow(() -> new RuntimeException("Counselor not found"));
        Page<Counseling> counselings = counselingRepository.findByCounselorIdOrderByApplicationDateDesc(counselor, pageable);
        return counselings.map(counseling -> modelMapper.map(counseling, CounselingResponseDto.class));
    }
}