package com.unitalk.common.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "Users")
public class User{
    @Id
    @Column(unique = true, nullable = false)
    private String userCode; //사용자 코드, 학번 및 교번

    @Column(nullable = false)
    private String password; //사용자 암호

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createDate; // 생성일

    @Column(nullable = false)
    private Integer userType; //사용자 구분
}
