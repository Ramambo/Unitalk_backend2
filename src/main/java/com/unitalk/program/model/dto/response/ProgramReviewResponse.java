package com.unitalk.program.model.dto.response;

import com.unitalk.program.model.entity.ProgramApplicant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramReviewResponse {
    private Long reviewId; // 집단상담 후기 ID(PK)
    private ProgramApplicant programId; // 집단상담 신청 번호(FK)
    private ProgramApplicant studentCode; // 집단상담 신청 학번(FK)
    private BigDecimal rating; // 별점
    private String reviewContent; // 집단상담후기 내용
}
