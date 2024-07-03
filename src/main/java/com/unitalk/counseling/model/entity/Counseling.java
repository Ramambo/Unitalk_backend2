package com.unitalk.counseling.model.entity;

import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.Student;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "counseling")
@Builder
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Counseling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reqNo;  // 상담신청번호

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;  // 학생ID

    @ManyToOne
    @JoinColumn(name = "counselorId")
    private Employee counselorId;    // 상담사ID

    private LocalDate counselDate;  // 상담일(학생이 선택한 날짜)
    
    @ManyToOne
    @JoinColumn(name = "schNo")
    private CounselorSchedule schedule; // 학생이 선택한 시간

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime applicationDate;  // 신청일시

    private long counselMode;   // 대면1|비대면2

    @Column(nullable = false)
    private String counselType; // 상담분야

    private String applicationContent; // 신청내용

    private long status;    // 진행상태

    private String counselContent;  // 상담기록(상담사가 작성함)

    @LastModifiedDate
    private LocalDateTime recordTime;   // 상담기록을 작성한 시각

    @ManyToOne
    @JoinColumn(name = "previousReqNo")
    private Counseling previousReqCounseling;   // 이전상담번호

}
