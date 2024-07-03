package com.unitalk.counseling.model.entity;

import com.unitalk.common.model.entity.Employee;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "Counselor_Schedule")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CounselorSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long schNo;

    @ManyToOne
    @JoinColumn(name = "counselorId")
    private Employee counselor;

    private String days;    // 요일
    private long availTime; // 학교의 1~9교시를 숫자로 저장.
    private long status;    // 예약상태(활성1|비활성2)

}
