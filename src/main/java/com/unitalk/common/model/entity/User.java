package com.unitalk.common.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
//회원정보 Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private Integer userId; //사용자 ID, PK

    @Column(name = "dept_id", nullable = false)
    private String deptId; //부서코드, FK

    @Column(name = "user_no", nullable = false)
    private String userNo; //사용자 일련번호, FK

    @Column(name = "user_name", nullable = false)
    private String userName; //사용자 이름

    @Column(name = "email", nullable = true)
    private String email; //사용자 이메일

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber; //사용자 전화번호

    @Column(name = "registration_year", nullable = false)
    private LocalDateTime registrationYear; //입사(학)년도

    @Builder
    public User(Integer userId, String deptId, String userNo, String userName, String email, String phoneNumber, LocalDateTime registrationYear) {
        this.userId = userId;
        this.deptId = deptId;
        this.userNo = userNo;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registrationYear = registrationYear;
    }

}
