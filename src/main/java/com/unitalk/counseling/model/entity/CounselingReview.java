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
@Table(name = "counseling_reviews")
@NoArgsConstructor(access = PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
public class CounselingReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewNo; // 상담후기 일련번호

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student; // 학생 ID

    @ManyToOne
    @JoinColumn(name = "req_no")
    private Counseling counseling; // 상담신청번호

    private Long rating; // 별점

    private String content; // 내용

}
