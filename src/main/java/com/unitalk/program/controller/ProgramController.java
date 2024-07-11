package com.unitalk.program.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.unitalk.program.model.dto.request.ProgramRequestDto;
import com.unitalk.program.model.dto.response.ProgramResponseDto;
import com.unitalk.program.model.entity.Program;
import com.unitalk.program.service.ProgramFileService;
import com.unitalk.program.service.ProgramService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/program")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;
    private final ProgramFileService programFileService;

    // 집단상담 목록 조회
    @GetMapping("/list")
    public ResponseEntity<Page<ProgramResponseDto>> getAllPrograms(@RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "16") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProgramResponseDto> programs = programService.getAllPrograms(pageable);
        return new ResponseEntity<>(programs, HttpStatus.OK);
    }

    // 집단상담 필터 및 검색
    @GetMapping("/list/search")
    public ResponseEntity<Page<ProgramResponseDto>> getProgramsByFilters(
            @RequestParam(required = false) Long counselorNo,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String programName,
            @RequestParam(required = false) String programContent,
            @RequestParam(required = false) LocalDate recruitStart,
            @RequestParam(required = false) LocalDate recruitEnd,
            @RequestParam(required = false) LocalDate operationStart,
            @RequestParam(required = false) LocalDate operationEnd,
            @RequestParam(required = false) Long status,
            @RequestParam(required = false) Long viewCnt,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "16") int size,
            @RequestParam(required = false, defaultValue = "programNo") String sort) {

        Sort sorting;
        if ("status".equals(sort)) {
            sorting = Sort.by(Sort.Direction.ASC, sort);
        } else {
            sorting = Sort.by(Sort.Direction.DESC, sort);
        }
        Pageable pageable = PageRequest.of(page, size, sorting);

        Page<ProgramResponseDto> programs = programService.getProgramsByFilters(
                counselorNo, keyword, programName, programContent, recruitStart, recruitEnd,
                operationStart, operationEnd, status, viewCnt, pageable);
        return new ResponseEntity<>(programs, HttpStatus.OK);
    }

    // 집단상담 조회
    @GetMapping("/{programNo}")
    public ResponseEntity<ProgramResponseDto> getProgramById(@PathVariable Long programNo) {
        ProgramResponseDto program = programService.getProgramById(programNo);
        return new ResponseEntity<>(program, HttpStatus.OK);
    }

    // 집단상담 작성
    /*
        @RequestHeader("employeeNo") Long employeeNo
        요청 보낸 헤더에서 직원번호 추출하여 비교, 직원만 작성 가능
    */
    @PostMapping()
    public ResponseEntity<ProgramResponseDto> createProgram(
            @Valid @ModelAttribute("program") String programJson,
            @RequestPart("files") List<MultipartFile> files,
            @RequestHeader("employeeNo") Long employeeNo) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        ProgramRequestDto requestDto = objectMapper.readValue(programJson, ProgramRequestDto.class);

        ProgramResponseDto program = programService.createProgram(requestDto, employeeNo);
        programFileService.saveFiles(files, program.getProgramNo());

        return new ResponseEntity<>(program, HttpStatus.CREATED);
    }

    // 집단상담 수정
    @PutMapping("/{programNo}")
    public ResponseEntity<ProgramResponseDto> updateProgram(
            @PathVariable Long programNo,
            @Valid @ModelAttribute("program") String programJson,
            @RequestPart("files") List<MultipartFile> files,
            @RequestHeader("employeeNo") Long employeeNo) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        ProgramRequestDto requestDto = objectMapper.readValue(programJson, ProgramRequestDto.class);

        ProgramResponseDto program = programService.updateProgram(programNo, requestDto, employeeNo);
        programFileService.saveFiles(files, program.getProgramNo());

        return new ResponseEntity<>(program, HttpStatus.OK);
    }

    // 집단상담 삭제
    @DeleteMapping("/{programNo}")
    public ResponseEntity<Void> deleteProgram(@PathVariable Long programNo) {
        programService.deleteProgram(programNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 메인페이지 TOP12
    @GetMapping("/main/top12")
    public ResponseEntity<List<ProgramResponseDto>> getTop12Programs() {
        List<ProgramResponseDto> programs = programService.getTop12Programs();
        return new ResponseEntity<>(programs, HttpStatus.OK);
    }

}
