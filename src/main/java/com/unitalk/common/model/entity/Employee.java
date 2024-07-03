package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Getter
@Table(name = "Employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private Integer empId;

    private Integer loginNo;

    private String deptId;

    private String username;

    private String email;

    private String phoneNumber;

    private Timestamp registrationYear;

    private String deptDetail;

}
