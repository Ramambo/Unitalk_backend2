package com.unitalk.common.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Students")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "studentNo")
//학생정보 Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_no", nullable = false)
    private Long studentNo; //학생 일련번호, PK

    @OneToOne
    @JoinColumn(name = "student_id", unique = true, nullable = false, referencedColumnName = "user_id")
    private User user; //학생 ID(학번)

    @Column(name = "reg_date", nullable = false)
    private LocalDate regDate; //입학연월일

    @Column(name = "grade", nullable = false)
    private Long grade; //학년

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Employee professorId; //교직원 ID(지도교수)

    @Builder
    public Student(User user, LocalDate regDate, Long grade) {
        this.user = user;
        this.regDate = regDate;
        this.grade = grade;
    }

    //Setter for 지도교수 배정
    public void setProfessorId(Employee professorId) {
        this.professorId = professorId;
    }

}
