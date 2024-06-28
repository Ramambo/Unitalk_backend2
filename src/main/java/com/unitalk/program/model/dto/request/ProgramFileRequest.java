package com.unitalk.program.model.dto.request;

import com.unitalk.program.model.entity.Program;
import com.unitalk.program.model.entity.ProgramFile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramFileRequest {
    private Program programId; // 집단상담 ID(FK)
    private String fileName; // 집단상담 파일명
    private String filePath; // 집단상담 파일 경로

    // DTO 객체를 엔티티로 변환
    public ProgramFile toEntity() {
        return ProgramFile.builder()
                .programId(programId)
                .fileName(fileName)
                .filePath(filePath)
                .build();
    }
}
