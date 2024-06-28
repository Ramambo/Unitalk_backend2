package com.unitalk.program.model.dto.request;

import com.unitalk.program.model.entity.Program;
import com.unitalk.program.model.entity.ProgramReview;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramReviewRequest {
    private Program programId; // 집단상담 ID(FK)
    private BigDecimal rating; // 별점
    private String reviewContent; // 집단상담후기 내용

    // DTO 객체를 엔티티로 변환
    public ProgramReview toEntity() {
        return ProgramReview.builder()
                .programId(programId)
                .rating(rating)
                .reviewContent(reviewContent)
                .build();
    }
}
