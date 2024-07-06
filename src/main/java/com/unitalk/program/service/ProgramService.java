package com.unitalk.program.service;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.repository.EmployeeRepository;
import com.unitalk.program.model.dto.request.ProgramRequestDto;
import com.unitalk.program.model.dto.response.ProgramResponseDto;
import com.unitalk.program.model.entity.Program;
import com.unitalk.program.repository.ProgramRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ProgramService {

    private final ProgramRepository programRepository;
    private final EmployeeRepository employeeRepository;

    // 집단상담 목록 조회
    public Page<ProgramResponseDto> getAllPrograms(Pageable pageable) {
        Page<Program> programs = programRepository.findAllByOrderByProgramNoDesc(pageable);
        return programs.map(Program::toDto);
    }
    /* Stream API 메서드: map(Program::toDto);
       Program의 toDto를 참조한다.
    */

    // 집단상담 필터 및 검색
    public Page<ProgramResponseDto> getProgramsByFilters(Long counselorNo, String programName, String programContent,
                                                         LocalDate recruitStart, LocalDate recruitEnd,
                                                         LocalDate operationStart, LocalDate operationEnd,
                                                         Character status, Long viewCnt, Pageable pageable) {

        Page<Program> programs = programRepository.findByFilters(counselorNo, programName, programContent, recruitStart, recruitEnd,
                operationStart, operationEnd, status, viewCnt, pageable);
        return programs.map(Program::toDto);
    }

    // 집단상담 조회
    public ProgramResponseDto getProgramById(Long programNo) {
        Program program = programRepository.findById(programNo)
                .orElseThrow(() -> new EntityNotFoundException("게시글이 없습니다." + programNo));
        return program.toDto();
    }

    // 집단상담 작성
    @Transactional
    public ProgramResponseDto createProgram(ProgramRequestDto requestDto) {

        // 상담사 정보 조회
        Employee counselor = employeeRepository.findById(requestDto.getCounselorNo())
                    .orElseThrow(() -> new EntityNotFoundException("해당 상담사 정보가 없습니다." + requestDto.getCounselorNo()));

        Program program = Program.builder()
                .counselor(counselor)
                .programName(requestDto.getProgramName())
                .programContent(requestDto.getProgramContent())
                .recruitStart(requestDto.getRecruitStart())
                .recruitEnd(requestDto.getRecruitEnd())
                .operationStart(requestDto.getOperationStart())
                .operationEnd(requestDto.getOperationEnd())
                .programSession(requestDto.getProgramSession())
                .recruitNum(requestDto.getRecruitNum())
                .status(requestDto.getStatus())
                .viewCnt(requestDto.getViewCnt())
                .build();

        program = programRepository.save(program);
        return program.toDto();
    }

    // 집단상담 수정
    @Transactional
    public ProgramResponseDto updateProgram(Long programNo, ProgramRequestDto requestDto) {
        Program program = programRepository.findById(programNo)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 없습니다." + programNo));

        // 상담사 정보 조회(상담사는 수정 안함)
        Employee counselor = employeeRepository.findById(requestDto.getCounselorNo())
                .orElseThrow(() -> new EntityNotFoundException("해당 상담사 정보가 없습니다." + requestDto.getCounselorNo()));

        program.update(requestDto.getProgramName(), requestDto.getProgramContent(),
                requestDto.getRecruitStart(), requestDto.getRecruitEnd(),
                requestDto.getOperationStart(), requestDto.getOperationEnd(),
                requestDto.getProgramSession(), requestDto.getRecruitNum(),
                requestDto.getStatus(), requestDto.getViewCnt());
        program.setCounselor(counselor);
        return programRepository.save(program).toDto();
    }

    // 집단상담 삭제
    @Transactional
    public void deleteProgram(Long programNo) {
        Program program = programRepository.findById(programNo)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 없습니다." + programNo));
        programRepository.delete(program);
    }

}
