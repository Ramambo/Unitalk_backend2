package com.unitalk.program.service;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.Student;
import com.unitalk.common.repository.EmployeeRepository;
import com.unitalk.common.repository.StudentRepository;
import com.unitalk.program.model.dto.request.ProgramApplicantRequestDto;
import com.unitalk.program.model.dto.response.ProgramApplicantResponseDto;
import com.unitalk.program.model.entity.Program;
import com.unitalk.program.model.entity.ProgramApplicant;
import com.unitalk.program.repository.ProgramApplicantRepository;
import com.unitalk.program.repository.ProgramRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ProgramApplicantService {

    private final ProgramApplicantRepository programApplicantRepository;
    private final ProgramRepository programRepository;
    private final StudentRepository studentRepository;

    // 학생의 집단상담 신청 조회
    @Transactional(readOnly = true)
    public Page<ProgramApplicantResponseDto> getStudentApplications(Long studentId, Pageable pageable) {
        return programApplicantRepository.findByStudentUserUserIdOrderByApplicantDateDesc(studentId, pageable)
                .map(this::ProgramDto);
    }

    // 학생의 집단상담 신청 작성
    @Transactional
    public ProgramApplicantResponseDto applyForProgram(ProgramApplicantRequestDto requestDto) {
        Long studentNo = requestDto.getStudentNo();
        Long programNo = requestDto.getProgramNo();
        // 프로그램 존재 여부 확인
        Program program = programRepository.findById(programNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로그램이 없습니다."));
        // 프로그램 상태 확인 (1: 신청가능)
        if (!program.getStatus().equals(1L)) {
            throw new IllegalStateException("현재 프로그램은 신청 불가 상태입니다.");
        }
        // 현재 날짜가 신청 기간 내인지 확인
        LocalDate now = LocalDate.now();
        if (now.isBefore(program.getRecruitStart()) || now.isAfter(program.getRecruitEnd())) {
            throw new IllegalStateException("신청 기간이 아닙니다.");
        }
        // 학생 존재 여부 확인
        Student student = studentRepository.findById(requestDto.getStudentNo())
                .orElseThrow(() -> new IllegalArgumentException("해당 학생이 없습니다."));
        // 이미 신청한 내역이 있는지 확인
        ProgramApplicant existingApplication = programApplicantRepository.findByProgramNoAndStudentStudentNo(programNo, studentNo);
        if (existingApplication != null && existingApplication.getStatus().equals(1L)) {
            throw new IllegalStateException("이미 신청한 프로그램입니다.");
        }
        ProgramApplicant application = ProgramApplicant.builder()
                .program(program)
                .student(student)
                .applicantDate(now)
                .status(1L)
                .build();
        // 신청 저장
        ProgramApplicant savedApplication = programApplicantRepository.save(application);
        return new ProgramApplicantResponseDto(savedApplication);
    }

    // 전교생 집단상담 신청 목록 조회(교직원, 상담사)
    @Transactional(readOnly = true)
    public Page<ProgramApplicantResponseDto> getAllApplicants(Pageable pageable) {
        Page<ProgramApplicant> applicants = programApplicantRepository.findAllByOrderByApplicantDateDesc(pageable);
        return applicants.map(this::ProgramDto);
    }

    // 집단상담 필터 및 검색
    @Transactional(readOnly = true)
    public Page<ProgramApplicantResponseDto> getProgramApplicantByFilters(Long programNo, Long studentNo,
                                                                          LocalDate applicantDate, Long status, Pageable pageable) {
        Page<ProgramApplicant> applicants = programApplicantRepository.findByFilters(programNo, studentNo, applicantDate, status, pageable);
        return applicants.map(this::ProgramDto);
    }

    // 특정 프로그램의 신청 목록 조회
    @Transactional(readOnly = true)
    public Page<ProgramApplicantResponseDto> getApplicantsByProgram(Long programNo, Pageable pageable) {
        Page<ProgramApplicant> applicants = programApplicantRepository.findByProgramNo(programNo, pageable);
        return applicants.map(this::ProgramDto);
    }

    // 특정 프로그램 신청인 조회 필터 및 검색
    @Transactional(readOnly = true)
    public Page<ProgramApplicantResponseDto> getApplicantsByProgramWithFilters(Long programNo, String studentName,
                                                                               LocalDate applicantDate, Long status,
                                                                               Pageable pageable) {
        Page<ProgramApplicant> applicants = programApplicantRepository.findByProgramNoWithFilters(
                programNo, studentName, applicantDate, status, pageable);
        return applicants.map(this::ProgramDto);
    }

    // 집단상담 신청 수정(삭제)
    @Transactional
    public ProgramApplicantResponseDto cancelApplication(Long applicantNo) {
        // 신청내역 검증
        ProgramApplicant application = programApplicantRepository.findById(applicantNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 신청내역이 없습니다." + applicantNo));
        application.setStatus(2L);

        ProgramApplicant updatedApplication = programApplicantRepository.save(application);
        return ProgramDto(updatedApplication);
    }

    // 엔티티를 DTO로 변환
    private ProgramApplicantResponseDto ProgramDto(ProgramApplicant programApplicant) {
        return ProgramApplicantResponseDto.builder()
                .applicantNo(programApplicant.getApplicantNo())
                .program(programApplicant.getProgram())
                .userId(programApplicant.getStudent().getUser().getUserId())
                .userName(programApplicant.getStudent().getUser().getUserName())
                .applicantDate(programApplicant.getApplicantDate())
                .status(programApplicant.getStatus())
                .build();
    }

    // 집단상담 운영날짜 지난 후 상태 완료로 변경
    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void updateProgramApplicantStatuses() {
        LocalDate now = LocalDate.now();
        programApplicantRepository.updateStatus(now);
    }

}
