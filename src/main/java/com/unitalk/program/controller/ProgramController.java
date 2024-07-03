package com.unitalk.program.controller;

import com.unitalk.program.model.dto.request.ProgramRequest;
import com.unitalk.program.model.dto.response.ProgramResponse;
import com.unitalk.program.model.entity.Program;
import com.unitalk.program.service.ProgramService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;

    // 집단상담 목록 조회
    @GetMapping("/programs")
    // <?>는 제네릭 와일드카드로 반환 타입을 알 수 없을 때 사용
    public ResponseEntity<?> getAllProgram( @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Program> programPage = programService.retrieveAll(pageable);
        return ResponseEntity.ok(programPage);
    }

    // 검색 집단상담 목록 조회
    @GetMapping("/search/programs")
    public ResponseEntity<?> searchPrograms(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Program> programPage = programService.searchPrograms(keyword, pageable);
        return ResponseEntity.ok(programPage);
    }


    // 집단상담 조회
    @GetMapping("/program/{programId}")
    // @PathVariable URL 경로에서 변수 값 추출
    public ResponseEntity<?> getProgram(@PathVariable Integer programId) {
        ProgramResponse retrieve = programService.retrieve(programId).toDto();
        log.info("Reteieved DTO: {}", retrieve);
        return ResponseEntity.ok(retrieve);
    }

    // 집단상담 저장
    @PostMapping("/program")
    // @Valid를 사용해서 ProgramRequest 유효성 검사, BindingResult는 유효성 검사 결과 저장
    public ResponseEntity<?> createProgram(@RequestBody @Valid ProgramRequest programRequest, BindingResult bindingResult) {
        //유효성 검사에서 오류가 발생하면 로그에 오류를 기록, HTTP 400 Bad Request 응답과 오류 메시지 반환
        if(bindingResult.hasErrors()) {
            log.error("BindingResult: {}", bindingResult.getAllErrors());
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        ProgramResponse createProgram = programService.saveProgram(programRequest);
        log.info("Created DTO: {}", createProgram);
        return ResponseEntity.ok(createProgram);
    }

    // 집단상담 수정
    @PutMapping("/program/{programId}")
    public ResponseEntity<?> updateProgram(@PathVariable Integer programId, @RequestBody @Valid ProgramRequest programRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("BindingResult: {}", bindingResult.getAllErrors());
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        ProgramResponse updateProgram = programService.updateProgram(programId, programRequest);
        log.info("Updated DTO: {}", updateProgram);
        return ResponseEntity.ok(updateProgram);
    }

    // 집단상담 삭제
    @DeleteMapping("/program/{programId}")
    public ResponseEntity<?> deleteProgram(@PathVariable Integer programId) {
        programService.deleteProgram(programId);
        log.info("Deleted DTO: {}", programId);
        return ResponseEntity.ok("Successfully deleted programId" + programId);
    }


}
