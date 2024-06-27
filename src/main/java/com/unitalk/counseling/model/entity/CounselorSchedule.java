package com.unitalk.counseling.model.entity;

import com.unitalk.common.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "Counselor_Schedule")
@NoArgsConstructor
@AllArgsConstructor
public class CounselorSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int schNo;

    @ManyToOne
    @JoinColumn(name = "counselorId")
    private User counselorId;

    private String days;

    private byte availTime;

    private byte status;

}
