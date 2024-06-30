package com.unitalk.program.model.dto.request;

import com.unitalk.program.model.entity.Program;
import com.unitalk.program.model.entity.ProgramImg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramImgRequest {
    private Program programId; // 집단상담 번호(FK)
    private String imgName; // 집단상담 파일명
    private String imgSaveName; // 집단상담 파일 저장명
    private String imgPath; // 집단상담 파일 경로

    // DTO 객체를 엔티티로 변환
    public ProgramImg toEntity() {
        return ProgramImg.builder()
                .programId(programId)
                .imgName(imgName)
                .imgSaveName(imgSaveName)
                .imgPath(imgPath)
                .build();
    }
}
