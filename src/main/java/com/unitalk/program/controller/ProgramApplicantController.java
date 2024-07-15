package com.unitalk.program.controller;

import com.unitalk.program.model.dto.request.ProgramApplicantRequestDto;
import com.unitalk.program.model.dto.response.ProgramApplicantResponseDto;
import com.unitalk.program.service.ProgramApplicantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/api/applicant")
@RequiredArgsConstructor
public class ProgramApplicantController {

    private final ProgramApplicantService programApplicantService;

    // 학생의 집단상담 신청 조회
    @GetMapping("/{studentId}")
    public ResponseEntity<Page<ProgramApplicantResponseDto>> getStudentApplications(
            @PathVariable Long studentId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProgramApplicantResponseDto> applications = programApplicantService.getStudentApplications(studentId, pageable);
        return ResponseEntity.ok(applications);
    }

    // 집단상담 신청
    @PostMapping("/student")
    public ResponseEntity<ProgramApplicantResponseDto> createProgram(@RequestBody ProgramApplicantRequestDto requestDto) {
        ProgramApplicantResponseDto responseDto = programApplicantService.applyForProgram(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 전교생 집단상담 신청 목록 조회(교직원, 상담사)
    @GetMapping("/list")
    public ResponseEntity<Page<ProgramApplicantResponseDto>> getAllApplicants(@RequestParam(defaultValue = "0") int page,
                                                                              @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProgramApplicantResponseDto> applicants = programApplicantService.getAllApplicants(pageable);
        return  new ResponseEntity<>(applicants, HttpStatus.OK);
    }

    // 집단상담 신청 필터 및 검색
    @GetMapping("/list/search")
    public ResponseEntity<Page<ProgramApplicantResponseDto>> getProgramApplicantsByFilters(
            @RequestParam(required = false) Long programNo,
            @RequestParam(required = false) Long studentNo,
            @RequestParam(required = false) LocalDate applicantDate,
            @RequestParam(required = false) Long status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProgramApplicantResponseDto> applicants = programApplicantService.getProgramApplicantByFilters(
                programNo, studentNo, applicantDate, status, pageable);
        return new ResponseEntity<>(applicants, HttpStatus.OK);
    }

    // 특정 프로그램의 신청 목록 조회
    @GetMapping("/list/{programNo}")
    public ResponseEntity<Page<ProgramApplicantResponseDto>> getApplicantsByProgram(
            @PathVariable Long programNo,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProgramApplicantResponseDto> applicants = programApplicantService.getApplicantsByProgram(programNo, pageable);
        return ResponseEntity.ok(applicants);
    }

    // 특정 프로그램 신청인 조회 필터 및 검색
    @GetMapping("/list/{programNo}/search")
    public ResponseEntity<Page<ProgramApplicantResponseDto>> getApplicantsByProgramWithFilters(
            @PathVariable Long programNo,
            @RequestParam(required = false) String studentName,
            @RequestParam(required = false) LocalDate applicantDate,
            @RequestParam(required = false) Long status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProgramApplicantResponseDto> applicants = programApplicantService.getApplicantsByProgramWithFilters(
                programNo, studentName, applicantDate, status, pageable);
        return ResponseEntity.ok(applicants);
    }

    // 집단상담 신청 수정(삭제)
    @PatchMapping("/{applicantNo}")
    public ResponseEntity<ProgramApplicantResponseDto> cancelApplication(
            @PathVariable Long applicantNo) {
        ProgramApplicantResponseDto responseDto = programApplicantService.cancelApplication(applicantNo);
        return ResponseEntity.ok(responseDto);
    }

}
