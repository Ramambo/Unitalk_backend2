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

    //지도교수 배정 이력 일련번호, PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_no", nullable = false)
    private Long assignmentNo;

    //교수 ID, FK
    @ManyToOne
    @JoinColumn(name = "professor_no", nullable = false, referencedColumnName = "employee_no")
    private Employee professorNo;

    //학생 ID, FK
    @ManyToOne
    @JoinColumn(name = "student_no", nullable = false, referencedColumnName = "student_no")
    private Student studentNo;

    //지도교수 배정 일시
    @Column(name = "assignment_date", nullable = false)
    private LocalDateTime assignmentDate;

    @Builder
    public ProfessorAssignment(Employee professorNo, Student studentNo) {
        this.professorNo = professorNo;
        this.studentNo = studentNo;
    }

    //지도교수 배정 시점에 현재 시간을 assignmentDate로 설정
    @PrePersist
    protected void onCreate() {
        this.assignmentDate = LocalDateTime.now();
    }

}
