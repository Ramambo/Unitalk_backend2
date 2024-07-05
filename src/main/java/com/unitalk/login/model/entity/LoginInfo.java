package com.unitalk.login.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "LoginInfo")
public class LoginInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userNo; //로그인 번호(PK)

    @Column(unique = true, nullable = false)
    private Integer userId; //사용자 ID, 학번 및 교번

    @Column(nullable = false)
    private String password; //사용자 암호

    @Column(nullable = false)
    private Integer userType; //사용자 구분
}
