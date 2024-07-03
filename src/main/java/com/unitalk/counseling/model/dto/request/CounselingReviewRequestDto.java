package com.unitalk.counseling.model.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CounselingReviewRequestDto {

    private long reqNo;
    private Integer student;
    private BigDecimal rating;
    private String content;

}