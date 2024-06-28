package com.unitalk.program.model.dto.response;

import com.unitalk.program.model.entity.Program;
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
    private Integer reviewId; // 집단상담 후기 ID(PK)
    private Program programId; // 집단상담 ID(FK)
    private BigDecimal rating; // 별점
    private String reviewContent; // 집단상담후기 내용
}
