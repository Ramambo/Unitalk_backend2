package com.unitalk.program.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@Getter
@Builder
@Table(name = "Program_Img")
public class ProgramImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imgId; // 집단상담 파일 번호(PK)

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "programId", referencedColumnName = "programId", nullable = false)
    private Program program; // 집단상담 번호(FK)

    @Column(nullable = false)
    private String imgName; // 집단상담 파일명

    @Column(nullable = false)
    private String imgSaveName; // 집단상담 파일 저장명

    @Column(nullable = false)
    private String imgPath; // 집단상담 파일 경로

    // 엔티티 필드 업데이트
    public ProgramImg(Long imgId, Program programId, String imgName, String imgSaveName, String imgPath) {
        this.imgId = imgId;
        this.program = programId;
        this.imgName = imgName;
        this.imgSaveName = imgSaveName;
        this.imgPath = imgPath;
    }
}
