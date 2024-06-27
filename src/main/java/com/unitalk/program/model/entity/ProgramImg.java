package com.unitalk.program.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "Program_Img")
public class ProgramImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imgId; // 집단상담 이미지 ID(PK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programId", nullable = false)
    private Program programId; // 집단상담 ID(FK)

    @Column(nullable = false)
    private String imgName; // 집단상담 이미지명

    @Column(nullable = false)
    private String imgPath; // 집단상담 이미지 경로
}
