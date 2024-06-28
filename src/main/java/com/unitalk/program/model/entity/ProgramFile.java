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
@Table(name = "Program_File")
public class ProgramFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fileId; // 집단상담 파일 ID(PK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programId", nullable = false)
    private Program programId; // 집단상담 ID(FK)

    @Column(nullable = false)
    private String fileName; // 집단상담 파일명

    @Column(nullable = false)
    private String filePath; // 집단상담 파일 경로
}
