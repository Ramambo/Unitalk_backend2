package com.unitalk.program.service;

import com.unitalk.program.model.dto.request.ProgramRequest;
import com.unitalk.program.model.dto.response.ProgramResponse;
import com.unitalk.program.model.entity.Program;
import com.unitalk.program.repository.ProgramRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProgramService {

    // ProgramRepository 타입의 객체 참조
    private final ProgramRepository programRepository;

    // 집단상담 목록 조회
    @Transactional(readOnly = true)
    public Page<Program> retrieveAll(Pageable pageable) {
        // ProgramRepository의 모든 Program 엔티티 조회
        return programRepository.findAll(pageable);
    }

    // 검색 및 페이이지네이션
    @Transactional(readOnly = true)
    public Page<Program> searchPrograms(String keyword, Pageable pageable) {
        return programRepository.searchByKeyword(keyword, pageable);
    }

    // 집단상담 조회
    @Transactional(readOnly = true)
    public Program retrieve (final Integer programId) {
        // programId로 ProgramRepository에서 해당 Program 엔티티 조회
        // findById는 Optional<Program> 반환 //Optional<Program> 값(엔티티)이 있을수도 없을 수도 있는 컨테이너 조회 및 처리 클래스
        return programRepository.findById(programId)
                // 조회된 값(엔티티), 즉 Optional이 비었을 때 실행
                // EntityNotFoundException 사용자 정의 예외(메세지 던지게 해놓음)

                // ->는 람다 표현식으로 자체로서 메서드를 하나의 식으로 표현한 것(자체가 메서드로 메서드 또는 함수형 인터페이스 구현에 사용)
                // 메서드의 매개변수 역할 및 결과로 반환될 수 있다.
                .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 없습니다. programId" + programId));
    }
    /* 람다식 미사용
    public Program retrieve(final Integer programId) {
        Optional<Program> optionalProgram = programRepository.findById(programId);
        if (optionalProgram.isPresent()) {
            return optionalProgram.get();
        } else {
            throw new EntityNotFoundException("해당 게시글이 없습니다. programId: " + programId);
        }
    } */

    // 집단상담 저장
    @Transactional
    public ProgramResponse saveProgram(final ProgramRequest programRequest) {
        // ProgramRequest 객체를 Program 엔티티로 변환, DB 저장
        Program saveProgram = programRepository.save(programRequest.toEntity());
        // 저장된 데이터 기반 ProgramResponse 객체 생성 및 반환
        return ProgramResponse.builder()
                .programId(saveProgram.getProgramId())
                .counselorCode(saveProgram.getCounselorCode())
                .programName(saveProgram.getProgramName())
                .programContent(saveProgram.getProgramContent())
                .recruitStart(saveProgram.getRecruitStart())
                .recruitEnd(saveProgram.getRecruitEnd())
                .operationStart(saveProgram.getOperationStart())
                .operationEnd(saveProgram.getOperationEnd())
                .programSession(saveProgram.getProgramSession())
                .recruitNum(saveProgram.getRecruitNum())
                .status(saveProgram.getStatus())
                .viewCnt(saveProgram.getViewCnt())
                .build();
    }

    // 집단상담 수정
    @Transactional
    public ProgramResponse updateProgram(final Integer programId, final ProgramRequest programRequest) {
        // 집단상담 조회 retrieve 메서드 호출, programId에 해당 엔티티
        Program program = retrieve(programId);
        // 엔티티에 선언한 메서드 호출, ProgramRequest 데이터로 Program 업데이트
        program.update(programRequest.getProgramName(), programRequest.getProgramContent(),
                        programRequest.getRecruitStart(), programRequest.getRecruitEnd(),
                        programRequest.getOperationStart(), programRequest.getOperationEnd(),
                        programRequest.getProgramSession(), programRequest.getRecruitNum(),
                        programRequest.getStatus(), programRequest.getViewCnt());
        // 업데이트된 Program 엔티티 DB에 저장
        programRepository.save(program);
        // 저장된 데이터 기반 ProgramResponse 객체 생성 및 반환
        return ProgramResponse.builder()
                .programId(program.getProgramId())
                .counselorCode(program.getCounselorCode())
                .programName(program.getProgramName())
                .programContent(program.getProgramContent())
                .recruitStart(program.getRecruitStart())
                .recruitEnd(program.getRecruitEnd())
                .operationStart(program.getOperationStart())
                .operationEnd(program.getOperationEnd())
                .programSession(program.getProgramSession())
                .recruitNum(program.getRecruitNum())
                .status(program.getStatus())
                .viewCnt(program.getViewCnt())
                .build();
    }

    // 집단상담 삭제
    @Transactional
    public void deleteProgram(final Integer programId) {
        // programId에 해당하는 Program 엔티티 조회 후 delete로 삭제
        programRepository.delete(retrieve(programId));
        /* programRepository.deleteById(programId);을 사용하지 않는 이유
           retrieve 메서드 안의 Optional을 이용하기 위해서(값이 없을 때 예외를 던지기 위함) */
    }

}
