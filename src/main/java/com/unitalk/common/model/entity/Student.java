package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Students")
@Getter
@NoArgsConstructor
//학생정보 Entity
public class Student {

    @Id
    @Column(name = "student_id", nullable = false)
    private Integer studentId; //학생 ID(학번)

    @Column(name = "dept_id", nullable = false)
    private String deptId; //부서코드(학과)

    @Column(name = "login_no", nullable = false)
    private Integer loginNo; //로그인일련번호

    @Column(name = "student_name", nullable = false)
    private String studentName; //학생 이름

    @Column(name = "student_email", nullable = false)
    private String studentEmail; //학생 이메일

    @Column(name = "student_phone_number", nullable = false)
    private String studentPhoneNumber; //학생 전화번호

    @Column(name = "student_registration_year", nullable = false)
    private LocalDate studentRegistrationYear; //입학연월일

    @Column(name = "grade", nullable = false)
    private Integer grade; //학년

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee; //교직원 ID(지도교수)

    @Builder
    public Student(Integer studentId, String deptId, Integer loginNo, String studentName, String studentEmail, String studentPhoneNumber, LocalDate studentRegistrationYear, Integer grade) {
        this.studentId = studentId;
        this.deptId = deptId;
        this.loginNo = loginNo;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPhoneNumber = studentPhoneNumber;
        this.studentRegistrationYear = studentRegistrationYear;
        this.grade = grade;
    }

    //Setter for 지도교수 배정
    public void setEmployeeId(Employee employee) {
        this.employee = employee;
    }

}
