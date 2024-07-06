package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "Students")
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @Column(name = "student_no")    // 학생일련번호
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentNo;

    @OneToOne
    @JoinColumn(name = "student_id", nullable = false) // 학생번호
    private User user;

    @Column(name = "reg_date", nullable = false)  // 입학일
    private LocalDate regDate;

    @Column(name = "grade", nullable = false) // 학년
    private Long grade;

    @ManyToOne
    @JoinColumn(name = "professor_no")  // 교수일련번호
    private Employee professor;

}
