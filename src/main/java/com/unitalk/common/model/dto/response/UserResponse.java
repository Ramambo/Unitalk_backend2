package com.unitalk.common.model.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String userCode; //사용자 코드, 학번 및 교번
    private String password; //사용자 암호
    private LocalDateTime createDate; // 생성일
    private Integer userType; //사용자 구분
}
