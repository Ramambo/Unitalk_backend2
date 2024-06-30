package com.unitalk.program.controller;

import com.unitalk.program.model.dto.request.ProgramRequest;
import com.unitalk.program.service.ProgramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ProgramController {

    private final ProgramService programService;

    // 집단상담 저장
    @PostMapping("/program/save")
    public ResponseEntity<?> saveProgram(@RequestBody ProgramRequest programRequest) {
        programService.saveProgram(programRequest);
        return ResponseEntity.ok().build();
    }
}
