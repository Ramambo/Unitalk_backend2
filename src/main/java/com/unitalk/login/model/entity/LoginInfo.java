package com.unitalk.login.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "Login_Info")
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginNo;

    @Column(unique = true, nullable = false)
    private Long userId;

    private String password;

    private String userType;

}
