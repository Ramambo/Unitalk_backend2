package com.unitalk.common.model.entity;

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
@Table(name = "Login_info")
public class LoginInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userNo; //사용자 일련번호(PK)

    @Column(nullable = false)
    private Integer userId; //사용자 ID

    @Column(nullable = false)
    private String password; //사용자 암호

    @Column(nullable = false)
    private Integer userType; //사용자 구분
}
