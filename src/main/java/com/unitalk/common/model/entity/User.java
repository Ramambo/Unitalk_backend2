package com.unitalk.common.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
@Getter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
//사용자정보 Entity
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId; //사용자 ID(학번/직번)

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department deptId; //부서코드(부서/학과)

    @Column(name = "user_name", nullable = false)
    private String userName; //사용자 이름

    @Column(name = "tel", nullable = false)
    private String tel; //사용자 전화번호

    @Column(name = "email", nullable = false)
    private String email; //사용자 이메일
    
    @Column(name = "user_type", nullable = false)
    private String userType; //사용자 구분

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Employee employee;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private LoginInfo loginNo;

}
