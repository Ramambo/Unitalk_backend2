package com.unitalk.program.service;

import com.unitalk.program.model.dto.request.ProgramRequest;
import com.unitalk.program.model.dto.response.ProgramResponse;
import com.unitalk.program.model.entity.Program;
import com.unitalk.program.repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramService {

    private final ProgramRepository programRepository;

    // 집단상담 저장
    public ProgramResponse saveProgram(final ProgramRequest programRequest) {
        Program saveProgram = programRepository.save(programRequest.toEntity());

        return ProgramResponse.builder()
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
}
