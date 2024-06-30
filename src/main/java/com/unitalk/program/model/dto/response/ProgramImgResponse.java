package com.unitalk.program.model.dto.response;

import com.unitalk.program.model.entity.Program;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramImgResponse {
    private Integer imgId; // 집단상담 파일 번호(PK)
    private Program programId; // 집단상담 번호(FK)
    private String imgName; // 집단상담 파일명
    private String imgSaveName; // 집단상담 파일 저장명
    private String imgPath; // 집단상담 파일 경로
}
