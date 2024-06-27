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
    private Integer assignmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private User studentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professorId")
    private User professorId;

    private Timestamp assignmentDate;

}
