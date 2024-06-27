package com.unitalk.program.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "ProgramReviews")
public class ProgramReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId; // 집단상담 후기 ID(PK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programId", nullable = false)
    private Program programId; // 집단상담 ID(FK)

    @Column(nullable = false)
    private BigDecimal rating; // 별점

    @Column(nullable = false)
    private String reviewContent; // 집단상담후기 내용
}
