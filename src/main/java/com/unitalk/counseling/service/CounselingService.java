package com.unitalk.counseling.service;

import com.unitalk.counseling.model.dto.CounselingCountsDto;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
        Student student = studentRepository.findById(requestDto.getStudentNo())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Employee counselor = employeeRepository.findById(requestDto.getCounselorNo())
                .orElseThrow(() -> new RuntimeException("Counselor not found"));

        Counseling counseling = modelMapper.map(requestDto, Counseling.class);
        counseling.setStudent(student);
        counseling.setCounselor(counselor);
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
    public Page<CounselingResponseDto> getCounselingsByStudentNo(Long studentNo, Pageable pageable) {
        Student student = studentRepository.findById(studentNo)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Page<Counseling> counselings = counselingRepository.findByStudentOrderByApplicationDateDesc(student, pageable);
        return counselings.map(counseling -> modelMapper.map(counseling, CounselingResponseDto.class));
    }

    // 상담자ID로 해당 상담사의 모든 상담 정보 조회
    public Page<CounselingResponseDto> getCounselingsByCounselorNo(Long counselorNo, Pageable pageable) {
        Employee counselor = employeeRepository.findById(counselorNo)
                .orElseThrow(() -> new RuntimeException("Counselor not found"));
        Page<Counseling> counselings = counselingRepository.findByCounselorOrderByApplicationDateDesc(counselor, pageable);
        return counselings.map(counseling -> modelMapper.map(counseling, CounselingResponseDto.class));
    }

    public CounselingCountsDto getCounselingCountsByStudentNo(Long studentNo) {
        List<Counseling> counselings = counselingRepository.findByStudent_StudentNo(studentNo);
        CounselingCountsDto counts = new CounselingCountsDto();

        for (Counseling counseling : counselings) {
            String counselType = counseling.getDepartment().getDeptId();
            switch (counselType) {
                case "PROF":
                    counts.setProfessorCounseling(counts.getProfessorCounseling() + 1);
                    break;
                case "PERS":
                    counts.setPersonalCounseling(counts.getPersonalCounseling() + 1);
                    break;
                case "SEXH":
                    counts.setSexualHarassmentCounseling(counts.getSexualHarassmentCounseling() + 1);
                    break;
                case "WELF":
                    counts.setStudentWelfareCounseling(counts.getStudentWelfareCounseling() + 1);
                    break;
            }
        }
        return counts;
    }

    public Page<CounselingResponseDto> getCounselingsByStudentNoWithFilters(
            Long studentNo, Long counselMode, Long status, String counselType,
            LocalDate startDate, LocalDate endDate, Pageable pageable) {

        Page<Counseling> counselings = counselingRepository.findByFilters(
                studentNo, counselMode, status, counselType, startDate, endDate, pageable);

        return counselings.map(counseling -> modelMapper.map(counseling, CounselingResponseDto.class));
    }
}