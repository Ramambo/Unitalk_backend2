package com.unitalk.counseling.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.unitalk.common.model.entity.Department;
import com.unitalk.common.model.entity.Employee;
import com.unitalk.common.model.entity.Student;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter // modelMapper사용시 엔티티에 세터 추가 필요
@Table(name = "Counseling")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "reqNo")
public class Counseling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reqNo; // 상담신청번호

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student; //학생ID

    @ManyToOne
    @JoinColumn(name = "counselorId")
    private Employee employee; //상담사 ID

    @ManyToOne
    @JoinColumn(name = "schNo")
    private CounselorSchedule counselorSchedule;

    private LocalDateTime applicationDate; // 상담 신청일시

    private long counselMode; // 대면1 , 비대면2

    @ManyToOne
    @JoinColumn(name = "counselType")
    private Department department; //상담분야

    private String applicationContent; // 상담 신청 내용

    private long status; // 상담 진행 상태 (1 : 대기, 2 : 승인, 3 : 완료, 8: 불참, 9 : 취소)

    private String counselContent; // 상담기록(상담사가 작성)
    
    private LocalDateTime recordTime; // 상담기록을 작성한 시각

    private LocalDateTime counselDate; // 상담일(학생이 선택한 날짜)

    @ManyToOne
    @JoinColumn(name = "previousReqNo")
    private Counseling previousReqNo; // 이전 상담 번호

}
