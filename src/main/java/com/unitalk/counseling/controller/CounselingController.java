package com.unitalk.counseling.controller;

import com.unitalk.counseling.model.dto.request.CounselingRequestDto;
import com.unitalk.counseling.model.dto.response.CounselingResponseDto;
import com.unitalk.counseling.service.CounselingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/counselings")
@RequiredArgsConstructor
public class CounselingController {

    private final CounselingService counselingService;

    // 새로운 상담 신청
    @PostMapping
    public ResponseEntity<CounselingResponseDto> createCounseling(@RequestBody CounselingRequestDto requestDto) {
        CounselingResponseDto responseDto = counselingService.createCounseling(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    // 상담 내용 업데이트
    @PutMapping("/{reqNo}")
    public ResponseEntity<CounselingResponseDto> updateCounseling(
            @PathVariable long reqNo,
            @RequestBody String counselContent) {
        CounselingResponseDto responseDto = counselingService.updateCounseling(reqNo, counselContent);
        return ResponseEntity.ok(responseDto);
    }

    // 상담 정보 개별 조회
    @GetMapping("/{reqNo}")
    public ResponseEntity<CounselingResponseDto> getCounselingById(@PathVariable long reqNo) {
        CounselingResponseDto responseDto = counselingService.getCounselingById(reqNo);
        return ResponseEntity.ok(responseDto);
    }

    // 학생의 모든 상담 정보 조회
    @GetMapping("/student/{studentId}")
    public ResponseEntity<Map<String, Object>> getCounselingsByStudentId(@PathVariable Long studentId,
                                                                                 @RequestParam(defaultValue = "0") int page,
                                                                                 @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CounselingResponseDto> responseDtos = counselingService.getCounselingsByStudentId(studentId, pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("content", responseDtos.getContent());
        response.put("currentPage", responseDtos.getNumber());
        response.put("totalPages", responseDtos.getTotalPages());

        return ResponseEntity.ok(response);
    }

    // 상담사의 모든 상담 정보 조회
    @GetMapping("/counselor/{counselorId}")
    public ResponseEntity<Map<String, Object>> getCounselingsByCounselorId(@PathVariable Long counselorId,
                                                                                   @RequestParam(defaultValue = "0") int page,
                                                                                   @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CounselingResponseDto> responseDtos = counselingService.getCounselingsByCounselorId(counselorId, pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("content", responseDtos.getContent());
        response.put("currentPage", responseDtos.getNumber());
        response.put("totalPages", responseDtos.getTotalPages());

        return ResponseEntity.ok(response);
    }
}