package com.unitalk.counseling.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.unitalk.common.model.entity.Department;
import com.unitalk.common.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Getter
@Table(name = "Counseling")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "reqNo")
public class Counseling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reqNo;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private User studentId;

    @ManyToOne
    @JoinColumn(name = "counselorId")
    private User counselorId;

    @ManyToOne
    @JoinColumn(name = "schNo")
    private CounselorSchedule schNo;

    private Timestamp applicationDate;

    private byte reqTime;

    private byte counselMode;

    @ManyToOne
    @JoinColumn(name = "counselType")
    private Department counselType;

    private String applicationContent;

    private byte status;

    private String counselContent;

    private Timestamp counselDate;

    @ManyToOne
    @JoinColumn(name = "previousReqNo")
    private Counseling previousReqNo;

}
