package com.unitalk.program.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InitializationService {

    private final ProgramService programService;
    private final ProgramApplicantService programApplicantService;

    // 생성자 수정: 두 개의 서비스 모두 주입받도록 수정
    public InitializationService(ProgramService programService, ProgramApplicantService programApplicantService) {
        this.programService = programService;
        this.programApplicantService = programApplicantService;
    }

    @PostConstruct
    @Transactional
    public void initialize() {
        // 프로그램 상태 초기화 호출
        programService.initializeProgramStatuses();

        // 집단상담 신청 상태 초기화 호출 (예시로 메소드 호출)
        programApplicantService.updateProgramApplicantStatuses();
    }
}