package com.unitalk.member.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JoinDTO {
    private Long userId; // 추가: 사용자 ID
    private String password;
    private String role;
    private String userType; // 추가: 사용자 타입
}
