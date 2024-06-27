package com.unitalk.counseling.model.entity;

import com.unitalk.common.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@Table(name = "Counseling_Reviews")
@NoArgsConstructor
@AllArgsConstructor
public class CounselingReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewNo;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private User studentId;

    @ManyToOne
    @JoinColumn(name = "reqNo")
    private Counseling reqNo;

    private BigDecimal rating;

    private String content;

}
