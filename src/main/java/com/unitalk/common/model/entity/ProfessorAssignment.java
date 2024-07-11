package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "Professor_Assignments")
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorAssignment {

    @Id
    @Column(name = "assignment_id") // 배정일련번호
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    @ManyToOne
    @JoinColumn(name = "professor_no", nullable = false)    // 교수일련번호
    private Employee professor;

    @Column(name = "assignment_date", nullable = false) // 배정일시
    private LocalDateTime assignmentDate;

    @ManyToOne
    @JoinColumn(name = "student_no", nullable = false)  // 학생일련번호
    private Student student;

}
