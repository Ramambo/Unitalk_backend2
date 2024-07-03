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
@Table(name = "Program_Reviews")
public class ProgramReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId; // 집단상담 후기 ID(PK)

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "programId", referencedColumnName = "programId", nullable = false)
    private ProgramApplicant programId; // 집단상담 신청 번호(FK)

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(unique = false, name = "studentCode", referencedColumnName = "studentCode")
    private ProgramApplicant studentCode; // 집단상담 신청 학번(FK)

    @Column(nullable = false)
    private BigDecimal rating; // 별점

    @Column(nullable = false)
    private String reviewContent; // 집단상담후기 내용
}
