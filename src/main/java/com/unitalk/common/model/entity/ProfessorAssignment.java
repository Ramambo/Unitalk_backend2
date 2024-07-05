package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Getter
@Table(name = "Professor_Assignments")
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student studentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professorId")
    private Employee professorId;

    private Timestamp assignmentDate;

}
