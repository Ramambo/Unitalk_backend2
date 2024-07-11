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

    //로그인정보 일련번호, PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_no", nullable = false)
    private Long loginNo;

    //사용자 ID, FK
    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    //사용자 비밀번호
    @Column(name = "pwd", nullable = false)
    private String pwd;

}
