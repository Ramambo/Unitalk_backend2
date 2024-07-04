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
    private Long studentId;

    @Column(unique = true, nullable = false)
    private Long loginNo;

    private String deptId;

    private String username;

    private String email;

    private String phoneNumber;

    private LocalDate registrationYear;

    private Long grade;

}
