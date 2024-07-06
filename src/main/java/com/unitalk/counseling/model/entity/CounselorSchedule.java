package com.unitalk.counseling.model.entity;

import com.unitalk.common.model.entity.Employee;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter @Setter
@Table(name = "Counselor_Schedule")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CounselorSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schNo;

    @ManyToOne
    @JoinColumn(name = "empId")
    private Employee empId;

    private String days; // 요일

    private Long availTime; // 학교의 1~9교시를 숫자로 저장

    private Long status; // 예약상태 활성1, 비활성 2

}
