package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "professor_assignments")
@Getter
@NoArgsConstructor
//지도교수 배정 이력 Entity
public class ProfessorAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id", nullable = false)
    private Integer assignmentId; //지도교수 배정 이력 일련번호, PK

    @Column(name = "professor_id", nullable = false)
    private Integer professorId; //교수 ID, FK

    @Column(name = "student_id", nullable = false)
    private Integer studentId; //학생 ID, FK

    @Column(name = "assignment_date", nullable = false)
    private LocalDateTime assignmentDate; //지도교수 배정 일시

    @Builder
    public ProfessorAssignment(Integer professorId, Integer studentId) {
        this.professorId = professorId;
        this.studentId = studentId;
    }

    //지도교수 배정 시점에 현재 시간을 assignmentDate로 설정
    @PrePersist
    protected void onCreate() {
        this.assignmentDate = LocalDateTime.now();
    }

}
