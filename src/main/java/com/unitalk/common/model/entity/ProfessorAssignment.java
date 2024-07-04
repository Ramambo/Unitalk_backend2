package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "Professor_Assignments")
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    private Long studentId;

    private Long professorId;

    private LocalDate assignmentDate;

}
