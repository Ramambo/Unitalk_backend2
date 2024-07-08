package com.unitalk.common.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Login_Info")
@Getter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "loginNo")
//로그인정보 Entity
public class LoginInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_no", nullable = false)
    private Long loginNo; //로그인정보 일련번호, PK

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user; //사용자 ID, FK

    @Column(name = "password", nullable = false)
    private String password; //사용자 비밀번호

}
