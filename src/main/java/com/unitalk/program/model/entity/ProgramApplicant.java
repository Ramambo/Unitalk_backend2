package com.unitalk.program.model.entity;

import com.unitalk.common.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "Program_Applicants")
public class ProgramApplicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applicantId; // 집단상담 신청 ID(PK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programId", nullable = false)
    private Program programId; // 집단상담 ID(FK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId", referencedColumnName = "userId", nullable = false)
    private User studentId; // 학생 ID(FK)

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime applicantDate; // 신청일

    @Column(nullable = false)
    private Character participationStatus; // 참여 여부
}
