package com.unitalk.common.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.unitalk.login.model.entity.LoginInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Getter
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
public class User {

    @Id
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department deptId;

    @ManyToOne
    @JoinColumn(name = "userNo")
    private LoginInfo userNo;

    private String username;

    private String email;

    private String phoneNumber;

    private Timestamp registrationYear;

}
