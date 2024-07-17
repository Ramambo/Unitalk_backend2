package com.unitalk.counseling.controller;

import com.unitalk.common.repository.EmployeeRepository;
import com.unitalk.counseling.model.dto.request.CounselingRequestDto;
import com.unitalk.counseling.model.dto.response.CounselingResponseDto;
import com.unitalk.counseling.model.dto.response.EmployeeResponseDto;
import com.unitalk.counseling.service.CounselingService;
import com.unitalk.counseling.service.ProfessorCounselingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/counselor/professor")
@RequiredArgsConstructor
public class ProfessorCounselingController {

    private final CounselingService counselingService;
    private final ProfessorCounselingService professorCounselingService;

    // 새로운 상담 신청
    @PostMapping
    public ResponseEntity<CounselingResponseDto> createCounseling(@RequestBody CounselingRequestDto requestDto) {
        CounselingResponseDto responseDto = counselingService.createCounseling(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    // 상담사(교수)의 모든 상담일정 조회
    @GetMapping("/findAll")
    public ResponseEntity<List<EmployeeResponseDto>> getCounselorFindAll(){
        log.info("getCounselorAll 교수 전체조회");
        final List<EmployeeResponseDto> response = professorCounselingService.getCounselorFindAll();
        return ResponseEntity.ok(response);
    }

    //상담사 타임별로 교직원 조회
    @GetMapping("/byCounselType")
    public ResponseEntity<List<EmployeeResponseDto>> getProfessorByCounselType(@RequestParam String deptDetail){
        List<EmployeeResponseDto> professors = professorCounselingService.getProfessorsByCounselType(deptDetail);
        return ResponseEntity.ok(professors);
    }

}