package com.unitalk.counseling.model.entity;

import com.unitalk.common.model.entity.Student;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "Counseling_Reviews")
@NoArgsConstructor(access = PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
public class CounselingReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewNo; // 상담후기 일련번호

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student studentId; // 학생 ID

    @ManyToOne
    @JoinColumn(name = "reqNo")
    private Counseling reqNo; // 상담신청번호

    private BigDecimal rating; // 별점

    private String content; // 내용

}
